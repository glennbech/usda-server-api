/**
 * This class is generated by jOOQ
 */
package com.glennbech.usda.model.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FdGroup extends org.jooq.impl.TableImpl<com.glennbech.usda.model.tables.records.FdGroupRecord> {

	private static final long serialVersionUID = -1046692221;

	/**
	 * The singleton instance of <code>usda.FD_GROUP</code>
	 */
	public static final com.glennbech.usda.model.tables.FdGroup FD_GROUP = new com.glennbech.usda.model.tables.FdGroup();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.glennbech.usda.model.tables.records.FdGroupRecord> getRecordType() {
		return com.glennbech.usda.model.tables.records.FdGroupRecord.class;
	}

	/**
	 * The column <code>usda.FD_GROUP.FdGrp_CD</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FdGroupRecord, java.lang.String> FDGRP_CD = createField("FdGrp_CD", org.jooq.impl.SQLDataType.VARCHAR.length(4).nullable(false), this, "");

	/**
	 * The column <code>usda.FD_GROUP.FdGrp_Desc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FdGroupRecord, java.lang.String> FDGRP_DESC = createField("FdGrp_Desc", org.jooq.impl.SQLDataType.VARCHAR.length(60), this, "");

	/**
	 * Create a <code>usda.FD_GROUP</code> table reference
	 */
	public FdGroup() {
		this("FD_GROUP", null);
	}

	/**
	 * Create an aliased <code>usda.FD_GROUP</code> table reference
	 */
	public FdGroup(java.lang.String alias) {
		this(alias, com.glennbech.usda.model.tables.FdGroup.FD_GROUP);
	}

	private FdGroup(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FdGroupRecord> aliased) {
		this(alias, aliased, null);
	}

	private FdGroup(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FdGroupRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.glennbech.usda.model.Usda.USDA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FdGroupRecord> getPrimaryKey() {
		return com.glennbech.usda.model.Keys.KEY_FD_GROUP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FdGroupRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FdGroupRecord>>asList(com.glennbech.usda.model.Keys.KEY_FD_GROUP_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.glennbech.usda.model.tables.FdGroup as(java.lang.String alias) {
		return new com.glennbech.usda.model.tables.FdGroup(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.glennbech.usda.model.tables.FdGroup rename(java.lang.String name) {
		return new com.glennbech.usda.model.tables.FdGroup(name, null);
	}
}
