package io.cattle.platform.servicediscovery.api.service.impl;

import static io.cattle.platform.core.model.tables.InstanceTable.INSTANCE;
import static io.cattle.platform.core.model.tables.ServiceConsumeMapTable.SERVICE_CONSUME_MAP;
import static io.cattle.platform.core.model.tables.ServiceTable.SERVICE;
import io.cattle.platform.allocator.service.AllocatorService;
import io.cattle.platform.core.addon.LoadBalancerServiceLink;
import io.cattle.platform.core.addon.ServiceLink;
import io.cattle.platform.core.constants.CommonStatesConstants;
import io.cattle.platform.core.constants.LoadBalancerConstants;
import io.cattle.platform.core.model.Instance;
import io.cattle.platform.core.model.Service;
import io.cattle.platform.core.model.ServiceConsumeMap;
import io.cattle.platform.docker.constants.DockerInstanceConstants;
import io.cattle.platform.docker.constants.DockerNetworkConstants;
import io.cattle.platform.object.ObjectManager;
import io.cattle.platform.object.process.ObjectProcessManager;
import io.cattle.platform.object.util.DataAccessor;
import io.cattle.platform.servicediscovery.api.constants.ServiceDiscoveryConstants;
import io.cattle.platform.servicediscovery.api.dao.ServiceConsumeMapDao;
import io.cattle.platform.servicediscovery.api.resource.ServiceDiscoveryConfigItem;
import io.cattle.platform.servicediscovery.api.service.RancherConfigToComposeFormatter;
import io.cattle.platform.servicediscovery.api.service.ServiceDiscoveryApiService;
import io.cattle.platform.servicediscovery.api.util.ServiceDiscoveryUtil;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.LineBreak;
import org.yaml.snakeyaml.Yaml;

@Named
public class ServiceDiscoveryApiServiceImpl implements ServiceDiscoveryApiService {
    @Inject
    ObjectManager objectManager;

    @Inject
    ObjectProcessManager objectProcessManager;

    @Inject
    ServiceConsumeMapDao consumeMapDao;

    @Inject
    List<RancherConfigToComposeFormatter> formatters;

    @Inject
    AllocatorService allocatorService;


    @Override
    public void addServiceLink(Service service, ServiceLink serviceLink) {
        ServiceConsumeMap map = consumeMapDao.findNonRemovedMap(service.getId(), serviceLink.getServiceId(),
                serviceLink.getName());

        if (map == null) {
            map = objectManager.create(ServiceConsumeMap.class,
                    SERVICE_CONSUME_MAP.SERVICE_ID,
                    service.getId(), SERVICE_CONSUME_MAP.CONSUMED_SERVICE_ID, serviceLink.getServiceId(),
                    SERVICE_CONSUME_MAP.ACCOUNT_ID, service.getAccountId(),
                    SERVICE_CONSUME_MAP.NAME, serviceLink.getName());
        }

        if (map.getState().equalsIgnoreCase(CommonStatesConstants.REQUESTED)) {
            objectProcessManager.scheduleProcessInstance(ServiceDiscoveryConstants.PROCESS_SERVICE_CONSUME_MAP_CREATE,
                    map, null);
        }
    }

    @Override
    public void removeServiceLink(Service service, ServiceLink serviceLink) {
        ServiceConsumeMap map = consumeMapDao.findMapToRemove(service.getId(), serviceLink.getServiceId());

        if (map != null) {
            objectProcessManager.scheduleProcessInstance(ServiceDiscoveryConstants.PROCESS_SERVICE_CONSUME_MAP_REMOVE,
                    map, null);
        }
    }

    @Override
    public void addLoadBalancerServiceLink(Service service, LoadBalancerServiceLink serviceLink) {
        if (!service.getKind().equalsIgnoreCase(ServiceDiscoveryConstants.KIND.LOADBALANCERSERVICE.name())) {
            return;
        }
        ServiceConsumeMap map = consumeMapDao.findNonRemovedMap(service.getId(), serviceLink.getServiceId(),
                serviceLink.getName());

        if (map == null) {
            map = objectManager.create(ServiceConsumeMap.class,
                    SERVICE_CONSUME_MAP.SERVICE_ID,
                    service.getId(), SERVICE_CONSUME_MAP.CONSUMED_SERVICE_ID, serviceLink.getServiceId(),
                    SERVICE_CONSUME_MAP.ACCOUNT_ID, service.getAccountId(),
                    SERVICE_CONSUME_MAP.NAME, serviceLink.getName(),
                    LoadBalancerConstants.FIELD_LB_TARGET_PORTS, serviceLink.getPorts());
        }

        if (map.getState().equalsIgnoreCase(CommonStatesConstants.REQUESTED)) {
            objectProcessManager.scheduleProcessInstance(ServiceDiscoveryConstants.PROCESS_SERVICE_CONSUME_MAP_CREATE,
                    map, null);
        }
    }

    @Override
    public List<? extends Service> listEnvironmentServices(long environmentId) {
        return objectManager.find(Service.class, SERVICE.ENVIRONMENT_ID, environmentId, SERVICE.REMOVED,
                null);
    }

    @Override
    public SimpleEntry<String, String> buildComposeConfig(List<? extends Service> services) {
        return new SimpleEntry<String, String>(buildDockerComposeConfig(services), buildRancherComposeConfig(services));
    }

    @Override
    public String buildDockerComposeConfig(List<? extends Service> services) {
        Map<String, Object> dockerComposeData = createComposeData(services, true);
        return convertToYml(dockerComposeData);
    }

    @Override
    public String buildRancherComposeConfig(List<? extends Service> services) {
        Map<String, Object> dockerComposeData = createComposeData(services, false);
        return convertToYml(dockerComposeData);
    }

    private String convertToYml(Map<String, Object> dockerComposeData) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setLineBreak(LineBreak.WIN);
        Yaml yaml = new Yaml(options);
        return yaml.dump(dockerComposeData);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> createComposeData(List<? extends Service> servicesToExport, boolean forDockerCompose) {
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<Long> servicesToExportIds = CollectionUtils.collect(servicesToExport,
                TransformerUtils.invokerTransformer("getId"));
        for (Service service : servicesToExport) {
            List<String> launchConfigNames = ServiceDiscoveryUtil.getServiceLaunchConfigNames(service);
            for (String launchConfigName : launchConfigNames) {
                Map<String, Object> rancherServiceData = ServiceDiscoveryUtil.getServiceDataAsMap(service,
                        launchConfigName, allocatorService);
                Map<String, Object> composeServiceData = new HashMap<>();
                for (String rancherService : rancherServiceData.keySet()) {
                    translateRancherToCompose(forDockerCompose, rancherServiceData, composeServiceData, rancherService);
                }

                if (forDockerCompose) {
                    populateLinksForService(service, servicesToExportIds, composeServiceData);
                    populateNetworkForService(service, launchConfigName, composeServiceData);
                    populateVolumesForService(service, launchConfigName, composeServiceData);
                    addExtraComposeParameters(service, launchConfigName, composeServiceData);
                }

                if (!composeServiceData.isEmpty()) {
                    data.put(
                            launchConfigName.equals(ServiceDiscoveryConstants.PRIMARY_LAUNCH_CONFIG_NAME) ? service
                                    .getName() : launchConfigName, composeServiceData);
                }
            }
        }
        return data;
    }

    private void populateLinksForService(Service service, Collection<Long> servicesToExportIds,
            Map<String, Object> composeServiceData) {
        List<String> serviceLinksWithNames = new ArrayList<>();
        List<Service> externalLinksServices = new ArrayList<>();
        List<? extends ServiceConsumeMap> consumedServiceMaps = consumeMapDao.findConsumedServices(service.getId());
        for (ServiceConsumeMap consumedServiceMap : consumedServiceMaps) {
            Service consumedService = objectManager.findOne(Service.class, SERVICE.ID,
                    consumedServiceMap.getConsumedServiceId());

            if (servicesToExportIds.contains(consumedServiceMap.getConsumedServiceId())) {
                String linkName = consumedServiceMap.getName() != null ? consumedServiceMap.getName() : consumedService
                        .getName();
                serviceLinksWithNames.add(consumedService.getName() + ":" + linkName);
            } else {
                externalLinksServices.add(consumedService);
            }
        }
        if (!serviceLinksWithNames.isEmpty()) {
            composeServiceData.put(ServiceDiscoveryConfigItem.LINKS.getDockerName(), serviceLinksWithNames);
        }
        populateExternalLinksForService(service, composeServiceData, externalLinksServices);
    }

    @SuppressWarnings("unchecked")
    private void populateExternalLinksForService(Service service, Map<String, Object> composeServiceData,
            List<Service> externalLinksServices) {

        Map<String, String> instanceLinksWithNamesMaps = new LinkedHashMap<String, String>();
        Map<String, Object> instanceLinksWithIds = (Map<String, Object>) composeServiceData
                .get(ServiceDiscoveryConfigItem.EXTERNALLINKS
                        .getDockerName());
        if (instanceLinksWithIds != null) {
            for (String linkName : instanceLinksWithIds.keySet()) {
                Instance instance = objectManager.findOne(Instance.class, INSTANCE.ID,
                        instanceLinksWithIds.get(linkName), INSTANCE.REMOVED,
                        null);
                String instanceName = ServiceDiscoveryUtil.getInstanceName(instance);
                if (instanceName != null) {
                    instanceLinksWithNamesMaps.put(instanceName, linkName);
                }
            }
        }

        if (!externalLinksServices.isEmpty()) {
            List<Instance> instances = objectManager.mappedChildren(service, Instance.class);
            for (Instance instance : instances) {
                String instanceName = ServiceDiscoveryUtil.getInstanceName(instance);
                if (instanceName != null) {
                    instanceLinksWithNamesMaps.put(instanceName, instanceName);
                }
            }
        }
        if (!instanceLinksWithNamesMaps.isEmpty()) {
            List<String> instanceLinksWithNames = new ArrayList<>();
            for (String instanceLinkName : instanceLinksWithNamesMaps.keySet()) {
                instanceLinksWithNames.add(instanceLinksWithNamesMaps.get(instanceLinkName) + ":" + instanceLinkName);
            }
            composeServiceData.put(ServiceDiscoveryConfigItem.EXTERNALLINKS.getDockerName(), instanceLinksWithNames);
        }
    }

    private void addExtraComposeParameters(Service service,
            String launchConfigName, Map<String, Object> composeServiceData) {
        if (service.getKind().equalsIgnoreCase(ServiceDiscoveryConstants.KIND.DNSSERVICE.name())) {
            composeServiceData.put(ServiceDiscoveryConfigItem.IMAGE.getDockerName(), "rancher/dns-service");
        } else if (service.getKind().equalsIgnoreCase(ServiceDiscoveryConstants.KIND.LOADBALANCERSERVICE.name())) {
            composeServiceData.put(ServiceDiscoveryConfigItem.IMAGE.getDockerName(), "rancher/load-balancer-service");
        } else if (service.getKind().equalsIgnoreCase(ServiceDiscoveryConstants.KIND.EXTERNALSERVICE.name())) {
            composeServiceData.put(ServiceDiscoveryConfigItem.IMAGE.getDockerName(), "rancher/external-service");
        }
    }

    private void populateNetworkForService(Service service,
            String launchConfigName, Map<String, Object> composeServiceData) {
        Object networkMode = composeServiceData.get(ServiceDiscoveryConfigItem.NETWORKMODE.getDockerName());
        if (networkMode != null) {
            if (networkMode.equals(DockerNetworkConstants.NETWORK_MODE_CONTAINER)) {
                Map<String, Object> serviceData = ServiceDiscoveryUtil.getLaunchConfigDataAsMap(service,
                        launchConfigName);
                // network mode can be passed by container, or by service name, so check both
                // networkFromContainerId wins
                Integer targetContainerId = DataAccessor
                        .fieldInteger(service, DockerInstanceConstants.DOCKER_CONTAINER);
                if (targetContainerId != null) {
                    Instance instance = objectManager.loadResource(Instance.class, targetContainerId.longValue());
                    String instanceName = ServiceDiscoveryUtil.getInstanceName(instance);
                    composeServiceData.put(ServiceDiscoveryConfigItem.NETWORKMODE.getDockerName(),
                            DockerNetworkConstants.NETWORK_MODE_CONTAINER + ":" + instanceName);
                } else {
                    Object networkLaunchConfig = serviceData
                            .get(ServiceDiscoveryConstants.FIELD_NETWORK_LAUNCH_CONFIG);
                    if (networkLaunchConfig != null) {
                        composeServiceData.put(ServiceDiscoveryConfigItem.NETWORKMODE.getDockerName(),
                                DockerNetworkConstants.NETWORK_MODE_CONTAINER + ":" + networkLaunchConfig);
                    }
                }
            } else if (networkMode.equals(DockerNetworkConstants.NETWORK_MODE_MANAGED)) {
                composeServiceData.remove(ServiceDiscoveryConfigItem.NETWORKMODE.getDockerName());
            }
        }
    }

    protected void translateRancherToCompose(boolean forDockerCompose, Map<String, Object> rancherServiceData,
            Map<String, Object> composeServiceData, String rancherService) {
        ServiceDiscoveryConfigItem item = ServiceDiscoveryConfigItem.getServiceConfigItemByCattleName(rancherService);
        if (item != null && item.isDockerComposeProperty() == forDockerCompose) {
            Object value = rancherServiceData.get(rancherService);
            boolean export = false;
            if (value instanceof List) {
                if (!((List<?>) value).isEmpty()) {
                    export = true;
                }
            } else if (value instanceof Map) {
                if (!((Map<?, ?>) value).isEmpty()) {
                    export = true;
                }
            } else if (value instanceof Boolean) {
                if (((Boolean) value).booleanValue()) {
                    export = true;
                }
            } else if (value != null) {
                export = true;
            }
            if (export) {
                // for every lookup, do transform
                Object formattedValue = null;
                for (RancherConfigToComposeFormatter formatter : formatters) {
                    formattedValue = formatter.format(item, value);
                    if (formattedValue != null) {
                        break;
                    }
                }
                if (formattedValue != null) {
                    composeServiceData.put(item.getDockerName().toLowerCase(), formattedValue);
                } else {
                    composeServiceData.put(item.getDockerName().toLowerCase(), value);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void populateVolumesForService(Service service, String launchConfigName,
            Map<String, Object> composeServiceData) {
        List<String> namesCombined = new ArrayList<>();
        List<String> launchConfigNames = new ArrayList<>();
        Map<String, Object> launchConfigData = ServiceDiscoveryUtil.getLaunchConfigDataAsMap(service, launchConfigName);
        Object dataVolumesLaunchConfigs = launchConfigData.get(
                ServiceDiscoveryConstants.FIELD_DATA_VOLUMES_LAUNCH_CONFIG);

        if (dataVolumesLaunchConfigs != null) {
            launchConfigNames.addAll((List<String>) dataVolumesLaunchConfigs);
        }

        // 1. add launch config names
        namesCombined.addAll(launchConfigNames);

        // 2. add instance names if specified
        List<? extends Integer> instanceIds = (List<? extends Integer>) launchConfigData
                .get(DockerInstanceConstants.FIELD_VOLUMES_FROM);

        if (instanceIds != null) {
            for (Integer instanceId : instanceIds) {
                Instance instance = objectManager.findOne(Instance.class, INSTANCE.ID, instanceId, INSTANCE.REMOVED,
                        null);
                String instanceName = ServiceDiscoveryUtil.getInstanceName(instance);
                if (instanceName != null) {
                    namesCombined.add(instanceName);
                }
            }
        }

        if (!namesCombined.isEmpty()) {
            composeServiceData.put(ServiceDiscoveryConfigItem.VOLUMESFROM.getDockerName(), namesCombined);
        }
    }
    
}
