/**
 * This class is generated by jOOQ
 */
package io.cattle.platform.core.model.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ExternalHandlerExternalHandlerProcessMapTable extends org.jooq.impl.TableImpl<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord> {

	private static final long serialVersionUID = 1724156742;

	/**
	 * The singleton instance of <code>cattle.external_handler_external_handler_process_map</code>
	 */
	public static final io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP = new io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord> getRecordType() {
		return io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord.class;
	}

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.id</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.name</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.kind</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> KIND = createField("kind", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.uuid</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.description</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.state</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.created</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.util.Date> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.removed</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.util.Date> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.remove_time</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.util.Date> REMOVE_TIME = createField("remove_time", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.data</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.util.Map<String,Object>> DATA = createField("data", org.jooq.impl.SQLDataType.CLOB.length(16777215).asConvertedDataType(new io.cattle.platform.db.jooq.converter.DataConverter()), this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.external_handler_id</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.Long> EXTERNAL_HANDLER_ID = createField("external_handler_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.external_handler_process_id</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.Long> EXTERNAL_HANDLER_PROCESS_ID = createField("external_handler_process_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>cattle.external_handler_external_handler_process_map.on_error</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.String> ON_ERROR = createField("on_error", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>cattle.external_handler_external_handler_process_map</code> table reference
	 */
	public ExternalHandlerExternalHandlerProcessMapTable() {
		this("external_handler_external_handler_process_map", null);
	}

	/**
	 * Create an aliased <code>cattle.external_handler_external_handler_process_map</code> table reference
	 */
	public ExternalHandlerExternalHandlerProcessMapTable(java.lang.String alias) {
		this(alias, io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable.EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP);
	}

	private ExternalHandlerExternalHandlerProcessMapTable(java.lang.String alias, org.jooq.Table<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord> aliased) {
		this(alias, aliased, null);
	}

	private ExternalHandlerExternalHandlerProcessMapTable(java.lang.String alias, org.jooq.Table<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, io.cattle.platform.core.model.CattleTable.CATTLE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, java.lang.Long> getIdentity() {
		return io.cattle.platform.core.model.Keys.IDENTITY_EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord> getPrimaryKey() {
		return io.cattle.platform.core.model.Keys.KEY_EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord>>asList(io.cattle.platform.core.model.Keys.KEY_EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP_PRIMARY, io.cattle.platform.core.model.Keys.KEY_EXTERNAL_HANDLER_EXTERNAL_HANDLER_PROCESS_MAP_IDX_EH_EH_PROCESS_MAP_UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<io.cattle.platform.core.model.tables.records.ExternalHandlerExternalHandlerProcessMapRecord, ?>>asList(io.cattle.platform.core.model.Keys.FK_EH_EH_PROCESS_MAP__EXTERNAL_HANDLER_ID, io.cattle.platform.core.model.Keys.FK_EH_EH_PROCESS_MAP__EXTERNAL_HANDLER_PROCESS_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable as(java.lang.String alias) {
		return new io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable(alias, this);
	}

	/**
	 * Rename this table
	 */
	public io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable rename(java.lang.String name) {
		return new io.cattle.platform.core.model.tables.ExternalHandlerExternalHandlerProcessMapTable(name, null);
	}
}
