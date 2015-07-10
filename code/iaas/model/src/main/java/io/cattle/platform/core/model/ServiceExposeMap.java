/**
 * This class is generated by jOOQ
 */
package io.cattle.platform.core.model;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "service_expose_map", schema = "cattle")
public interface ServiceExposeMap extends java.io.Serializable {

	/**
	 * Setter for <code>cattle.service_expose_map.id</code>.
	 */
	public void setId(java.lang.Long value);

	/**
	 * Getter for <code>cattle.service_expose_map.id</code>.
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 19)
	public java.lang.Long getId();

	/**
	 * Setter for <code>cattle.service_expose_map.name</code>.
	 */
	public void setName(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.name</code>.
	 */
	@javax.persistence.Column(name = "name", length = 255)
	public java.lang.String getName();

	/**
	 * Setter for <code>cattle.service_expose_map.kind</code>.
	 */
	public void setKind(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.kind</code>.
	 */
	@javax.persistence.Column(name = "kind", nullable = false, length = 255)
	public java.lang.String getKind();

	/**
	 * Setter for <code>cattle.service_expose_map.uuid</code>.
	 */
	public void setUuid(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.uuid</code>.
	 */
	@javax.persistence.Column(name = "uuid", unique = true, nullable = false, length = 128)
	public java.lang.String getUuid();

	/**
	 * Setter for <code>cattle.service_expose_map.description</code>.
	 */
	public void setDescription(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.description</code>.
	 */
	@javax.persistence.Column(name = "description", length = 1024)
	public java.lang.String getDescription();

	/**
	 * Setter for <code>cattle.service_expose_map.state</code>.
	 */
	public void setState(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.state</code>.
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 128)
	public java.lang.String getState();

	/**
	 * Setter for <code>cattle.service_expose_map.created</code>.
	 */
	public void setCreated(java.util.Date value);

	/**
	 * Getter for <code>cattle.service_expose_map.created</code>.
	 */
	@javax.persistence.Column(name = "created")
	public java.util.Date getCreated();

	/**
	 * Setter for <code>cattle.service_expose_map.removed</code>.
	 */
	public void setRemoved(java.util.Date value);

	/**
	 * Getter for <code>cattle.service_expose_map.removed</code>.
	 */
	@javax.persistence.Column(name = "removed")
	public java.util.Date getRemoved();

	/**
	 * Setter for <code>cattle.service_expose_map.remove_time</code>.
	 */
	public void setRemoveTime(java.util.Date value);

	/**
	 * Getter for <code>cattle.service_expose_map.remove_time</code>.
	 */
	@javax.persistence.Column(name = "remove_time")
	public java.util.Date getRemoveTime();

	/**
	 * Setter for <code>cattle.service_expose_map.data</code>.
	 */
	public void setData(java.util.Map<String,Object> value);

	/**
	 * Getter for <code>cattle.service_expose_map.data</code>.
	 */
	@javax.persistence.Column(name = "data", length = 16777215)
	public java.util.Map<String,Object> getData();

	/**
	 * Setter for <code>cattle.service_expose_map.service_id</code>.
	 */
	public void setServiceId(java.lang.Long value);

	/**
	 * Getter for <code>cattle.service_expose_map.service_id</code>.
	 */
	@javax.persistence.Column(name = "service_id", precision = 19)
	public java.lang.Long getServiceId();

	/**
	 * Setter for <code>cattle.service_expose_map.instance_id</code>.
	 */
	public void setInstanceId(java.lang.Long value);

	/**
	 * Getter for <code>cattle.service_expose_map.instance_id</code>.
	 */
	@javax.persistence.Column(name = "instance_id", precision = 19)
	public java.lang.Long getInstanceId();

	/**
	 * Setter for <code>cattle.service_expose_map.account_id</code>.
	 */
	public void setAccountId(java.lang.Long value);

	/**
	 * Getter for <code>cattle.service_expose_map.account_id</code>.
	 */
	@javax.persistence.Column(name = "account_id", precision = 19)
	public java.lang.Long getAccountId();

	/**
	 * Setter for <code>cattle.service_expose_map.ip_address</code>.
	 */
	public void setIpAddress(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.ip_address</code>.
	 */
	@javax.persistence.Column(name = "ip_address", length = 255)
	public java.lang.String getIpAddress();

	/**
	 * Setter for <code>cattle.service_expose_map.dns_prefix</code>.
	 */
	public void setDnsPrefix(java.lang.String value);

	/**
	 * Getter for <code>cattle.service_expose_map.dns_prefix</code>.
	 */
	@javax.persistence.Column(name = "dns_prefix", length = 128)
	public java.lang.String getDnsPrefix();

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * Load data from another generated Record/POJO implementing the common interface ServiceExposeMap
	 */
	public void from(io.cattle.platform.core.model.ServiceExposeMap from);

	/**
	 * Copy data into another generated Record/POJO implementing the common interface ServiceExposeMap
	 */
	public <E extends io.cattle.platform.core.model.ServiceExposeMap> E into(E into);
}
