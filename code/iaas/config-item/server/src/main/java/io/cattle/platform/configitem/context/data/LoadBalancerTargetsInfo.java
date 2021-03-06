package io.cattle.platform.configitem.context.data;

import io.cattle.platform.core.addon.InstanceHealthCheck;
import io.cattle.platform.core.util.LoadBalancerTargetPortSpec;

import java.util.List;

public class LoadBalancerTargetsInfo {
    Integer uuid;
    LoadBalancerTargetPortSpec portSpec;
    List<LoadBalancerTargetInfo> targets;
    InstanceHealthCheck healthCheck;

    public LoadBalancerTargetsInfo(List<LoadBalancerTargetInfo> lbTargetInfo, InstanceHealthCheck lbHealthCheck) {
        super();
        this.targets = lbTargetInfo;
        for (LoadBalancerTargetInfo target : this.targets) {
            if (target.getHealthCheck() != null) {
                this.healthCheck = target.getHealthCheck();
                break;
            }
        }

        // LEGACY: to support the case when healtcheck is defined on LB + to support the case when targets are ip
        // addresses for stand alone LB case)
        if (this.healthCheck == null && lbHealthCheck != null) {
            this.healthCheck = lbHealthCheck;
        }

        if (!lbTargetInfo.isEmpty()) {
            this.portSpec = lbTargetInfo.get(0).getPortSpec();
            this.uuid = lbTargetInfo.get(0).getUuid();
        }
    }

    public List<LoadBalancerTargetInfo> getTargets() {
        return targets;
    }

    public void setTargets(List<LoadBalancerTargetInfo> targets) {
        this.targets = targets;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public LoadBalancerTargetPortSpec getPortSpec() {
        return portSpec;
    }

    public void setPortSpec(LoadBalancerTargetPortSpec portSpec) {
        this.portSpec = portSpec;
    }

    public InstanceHealthCheck getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(InstanceHealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }
}
