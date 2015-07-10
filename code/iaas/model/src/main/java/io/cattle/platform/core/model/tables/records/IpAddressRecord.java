/**
 * This class is generated by jOOQ
 */
package io.cattle.platform.core.model.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "ip_address", schema = "cattle")
public class IpAddressRecord extends org.jooq.impl.UpdatableRecordImpl<io.cattle.platform.core.model.tables.records.IpAddressRecord> implements io.cattle.platform.db.jooq.utils.TableRecordJaxb, org.jooq.Record18<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.util.Map<String,Object>, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Long>, io.cattle.platform.core.model.IpAddress {

	private static final long serialVersionUID = -1188013757;

	/**
	 * Setter for <code>cattle.ip_address.id</code>.
	 */
	@Override
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.id</code>.
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 19)
	@Override
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cattle.ip_address.name</code>.
	 */
	@Override
	public void setName(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.name</code>.
	 */
	@javax.persistence.Column(name = "name", length = 255)
	@Override
	public java.lang.String getName() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cattle.ip_address.account_id</code>.
	 */
	@Override
	public void setAccountId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.account_id</code>.
	 */
	@javax.persistence.Column(name = "account_id", precision = 19)
	@Override
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cattle.ip_address.kind</code>.
	 */
	@Override
	public void setKind(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.kind</code>.
	 */
	@javax.persistence.Column(name = "kind", nullable = false, length = 255)
	@Override
	public java.lang.String getKind() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cattle.ip_address.uuid</code>.
	 */
	@Override
	public void setUuid(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.uuid</code>.
	 */
	@javax.persistence.Column(name = "uuid", unique = true, nullable = false, length = 128)
	@Override
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>cattle.ip_address.description</code>.
	 */
	@Override
	public void setDescription(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.description</code>.
	 */
	@javax.persistence.Column(name = "description", length = 1024)
	@Override
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cattle.ip_address.state</code>.
	 */
	@Override
	public void setState(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.state</code>.
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 128)
	@Override
	public java.lang.String getState() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>cattle.ip_address.created</code>.
	 */
	@Override
	public void setCreated(java.util.Date value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.created</code>.
	 */
	@javax.persistence.Column(name = "created")
	@Override
	public java.util.Date getCreated() {
		return (java.util.Date) getValue(7);
	}

	/**
	 * Setter for <code>cattle.ip_address.removed</code>.
	 */
	@Override
	public void setRemoved(java.util.Date value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.removed</code>.
	 */
	@javax.persistence.Column(name = "removed")
	@Override
	public java.util.Date getRemoved() {
		return (java.util.Date) getValue(8);
	}

	/**
	 * Setter for <code>cattle.ip_address.remove_time</code>.
	 */
	@Override
	public void setRemoveTime(java.util.Date value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.remove_time</code>.
	 */
	@javax.persistence.Column(name = "remove_time")
	@Override
	public java.util.Date getRemoveTime() {
		return (java.util.Date) getValue(9);
	}

	/**
	 * Setter for <code>cattle.ip_address.data</code>.
	 */
	@Override
	public void setData(java.util.Map<String,Object> value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.data</code>.
	 */
	@javax.persistence.Column(name = "data", length = 16777215)
	@Override
	public java.util.Map<String,Object> getData() {
		return (java.util.Map<String,Object>) getValue(10);
	}

	/**
	 * Setter for <code>cattle.ip_address.address</code>.
	 */
	@Override
	public void setAddress(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.address</code>.
	 */
	@javax.persistence.Column(name = "address", length = 255)
	@Override
	public java.lang.String getAddress() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cattle.ip_address.subnet_id</code>.
	 */
	@Override
	public void setSubnetId(java.lang.Long value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.subnet_id</code>.
	 */
	@javax.persistence.Column(name = "subnet_id", precision = 19)
	@Override
	public java.lang.Long getSubnetId() {
		return (java.lang.Long) getValue(12);
	}

	/**
	 * Setter for <code>cattle.ip_address.network_id</code>.
	 */
	@Override
	public void setNetworkId(java.lang.Long value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.network_id</code>.
	 */
	@javax.persistence.Column(name = "network_id", precision = 19)
	@Override
	public java.lang.Long getNetworkId() {
		return (java.lang.Long) getValue(13);
	}

	/**
	 * Setter for <code>cattle.ip_address.is_public</code>.
	 */
	@Override
	public void setIsPublic(java.lang.Boolean value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.is_public</code>.
	 */
	@javax.persistence.Column(name = "is_public", nullable = false, precision = 1)
	@Override
	public java.lang.Boolean getIsPublic() {
		return (java.lang.Boolean) getValue(14);
	}

	/**
	 * Setter for <code>cattle.ip_address.role</code>.
	 */
	@Override
	public void setRole(java.lang.String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.role</code>.
	 */
	@javax.persistence.Column(name = "role", length = 128)
	@Override
	public java.lang.String getRole() {
		return (java.lang.String) getValue(15);
	}

	/**
	 * Setter for <code>cattle.ip_address.hostname</code>.
	 */
	@Override
	public void setHostname(java.lang.String value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.hostname</code>.
	 */
	@javax.persistence.Column(name = "hostname", length = 255)
	@Override
	public java.lang.String getHostname() {
		return (java.lang.String) getValue(16);
	}

	/**
	 * Setter for <code>cattle.ip_address.ip_pool_id</code>.
	 */
	@Override
	public void setIpPoolId(java.lang.Long value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cattle.ip_address.ip_pool_id</code>.
	 */
	@javax.persistence.Column(name = "ip_pool_id", precision = 19)
	@Override
	public java.lang.Long getIpPoolId() {
		return (java.lang.Long) getValue(17);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record18 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row18<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.util.Map<String,Object>, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Long> fieldsRow() {
		return (org.jooq.Row18) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row18<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.util.Map<String,Object>, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Long> valuesRow() {
		return (org.jooq.Row18) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.KIND;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.Date> field8() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.Date> field9() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.REMOVED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.Date> field10() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.REMOVE_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.util.Map<String,Object>> field11() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.DATA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field12() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.ADDRESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field13() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.SUBNET_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field14() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.NETWORK_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field15() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.IS_PUBLIC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field16() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.ROLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field17() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.HOSTNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field18() {
		return io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS.IP_POOL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getKind();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getUuid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.Date value8() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.Date value9() {
		return getRemoved();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.Date value10() {
		return getRemoveTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.Map<String,Object> value11() {
		return getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value12() {
		return getAddress();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value13() {
		return getSubnetId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value14() {
		return getNetworkId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value15() {
		return getIsPublic();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value16() {
		return getRole();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value17() {
		return getHostname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value18() {
		return getIpPoolId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value1(java.lang.Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value2(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value3(java.lang.Long value) {
		setAccountId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value4(java.lang.String value) {
		setKind(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value5(java.lang.String value) {
		setUuid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value6(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value7(java.lang.String value) {
		setState(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value8(java.util.Date value) {
		setCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value9(java.util.Date value) {
		setRemoved(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value10(java.util.Date value) {
		setRemoveTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value11(java.util.Map<String,Object> value) {
		setData(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value12(java.lang.String value) {
		setAddress(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value13(java.lang.Long value) {
		setSubnetId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value14(java.lang.Long value) {
		setNetworkId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value15(java.lang.Boolean value) {
		setIsPublic(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value16(java.lang.String value) {
		setRole(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value17(java.lang.String value) {
		setHostname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord value18(java.lang.Long value) {
		setIpPoolId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpAddressRecord values(java.lang.Long value1, java.lang.String value2, java.lang.Long value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.String value7, java.util.Date value8, java.util.Date value9, java.util.Date value10, java.util.Map<String,Object> value11, java.lang.String value12, java.lang.Long value13, java.lang.Long value14, java.lang.Boolean value15, java.lang.String value16, java.lang.String value17, java.lang.Long value18) {
		return this;
	}

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void from(io.cattle.platform.core.model.IpAddress from) {
		setId(from.getId());
		setName(from.getName());
		setAccountId(from.getAccountId());
		setKind(from.getKind());
		setUuid(from.getUuid());
		setDescription(from.getDescription());
		setState(from.getState());
		setCreated(from.getCreated());
		setRemoved(from.getRemoved());
		setRemoveTime(from.getRemoveTime());
		setData(from.getData());
		setAddress(from.getAddress());
		setSubnetId(from.getSubnetId());
		setNetworkId(from.getNetworkId());
		setIsPublic(from.getIsPublic());
		setRole(from.getRole());
		setHostname(from.getHostname());
		setIpPoolId(from.getIpPoolId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <E extends io.cattle.platform.core.model.IpAddress> E into(E into) {
		into.from(this);
		return into;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached IpAddressRecord
	 */
	public IpAddressRecord() {
		super(io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS);
	}

	/**
	 * Create a detached, initialised IpAddressRecord
	 */
	public IpAddressRecord(java.lang.Long id, java.lang.String name, java.lang.Long accountId, java.lang.String kind, java.lang.String uuid, java.lang.String description, java.lang.String state, java.util.Date created, java.util.Date removed, java.util.Date removeTime, java.util.Map<String,Object> data, java.lang.String address, java.lang.Long subnetId, java.lang.Long networkId, java.lang.Boolean isPublic, java.lang.String role, java.lang.String hostname, java.lang.Long ipPoolId) {
		super(io.cattle.platform.core.model.tables.IpAddressTable.IP_ADDRESS);

		setValue(0, id);
		setValue(1, name);
		setValue(2, accountId);
		setValue(3, kind);
		setValue(4, uuid);
		setValue(5, description);
		setValue(6, state);
		setValue(7, created);
		setValue(8, removed);
		setValue(9, removeTime);
		setValue(10, data);
		setValue(11, address);
		setValue(12, subnetId);
		setValue(13, networkId);
		setValue(14, isPublic);
		setValue(15, role);
		setValue(16, hostname);
		setValue(17, ipPoolId);
	}
}
