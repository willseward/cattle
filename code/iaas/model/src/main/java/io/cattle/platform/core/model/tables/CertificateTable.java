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
public class CertificateTable extends org.jooq.impl.TableImpl<io.cattle.platform.core.model.tables.records.CertificateRecord> {

	private static final long serialVersionUID = -1971831805;

	/**
	 * The singleton instance of <code>cattle.certificate</code>
	 */
	public static final io.cattle.platform.core.model.tables.CertificateTable CERTIFICATE = new io.cattle.platform.core.model.tables.CertificateTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<io.cattle.platform.core.model.tables.records.CertificateRecord> getRecordType() {
		return io.cattle.platform.core.model.tables.records.CertificateRecord.class;
	}

	/**
	 * The column <code>cattle.certificate.id</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>cattle.certificate.name</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>cattle.certificate.account_id</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>cattle.certificate.kind</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> KIND = createField("kind", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>cattle.certificate.uuid</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * The column <code>cattle.certificate.description</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

	/**
	 * The column <code>cattle.certificate.state</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * The column <code>cattle.certificate.created</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.util.Date> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.certificate.removed</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.util.Date> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.certificate.remove_time</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.util.Date> REMOVE_TIME = createField("remove_time", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new io.cattle.platform.db.jooq.converter.DateConverter()), this, "");

	/**
	 * The column <code>cattle.certificate.data</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.util.Map<String,Object>> DATA = createField("data", org.jooq.impl.SQLDataType.CLOB.length(16777215).asConvertedDataType(new io.cattle.platform.db.jooq.converter.DataConverter()), this, "");

	/**
	 * The column <code>cattle.certificate.cert_chain</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> CERT_CHAIN = createField("cert_chain", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "");

	/**
	 * The column <code>cattle.certificate.cert</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> CERT = createField("cert", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "");

	/**
	 * The column <code>cattle.certificate.key</code>.
	 */
	public final org.jooq.TableField<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.String> KEY = createField("key", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "");

	/**
	 * Create a <code>cattle.certificate</code> table reference
	 */
	public CertificateTable() {
		this("certificate", null);
	}

	/**
	 * Create an aliased <code>cattle.certificate</code> table reference
	 */
	public CertificateTable(java.lang.String alias) {
		this(alias, io.cattle.platform.core.model.tables.CertificateTable.CERTIFICATE);
	}

	private CertificateTable(java.lang.String alias, org.jooq.Table<io.cattle.platform.core.model.tables.records.CertificateRecord> aliased) {
		this(alias, aliased, null);
	}

	private CertificateTable(java.lang.String alias, org.jooq.Table<io.cattle.platform.core.model.tables.records.CertificateRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, io.cattle.platform.core.model.CattleTable.CATTLE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<io.cattle.platform.core.model.tables.records.CertificateRecord, java.lang.Long> getIdentity() {
		return io.cattle.platform.core.model.Keys.IDENTITY_CERTIFICATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.CertificateRecord> getPrimaryKey() {
		return io.cattle.platform.core.model.Keys.KEY_CERTIFICATE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.CertificateRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<io.cattle.platform.core.model.tables.records.CertificateRecord>>asList(io.cattle.platform.core.model.Keys.KEY_CERTIFICATE_PRIMARY, io.cattle.platform.core.model.Keys.KEY_CERTIFICATE_IDX_CERT_DATA_UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<io.cattle.platform.core.model.tables.records.CertificateRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<io.cattle.platform.core.model.tables.records.CertificateRecord, ?>>asList(io.cattle.platform.core.model.Keys.FK_CERT_DATA__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public io.cattle.platform.core.model.tables.CertificateTable as(java.lang.String alias) {
		return new io.cattle.platform.core.model.tables.CertificateTable(alias, this);
	}

	/**
	 * Rename this table
	 */
	public io.cattle.platform.core.model.tables.CertificateTable rename(java.lang.String name) {
		return new io.cattle.platform.core.model.tables.CertificateTable(name, null);
	}
}
