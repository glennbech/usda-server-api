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
public class FoodDes extends org.jooq.impl.TableImpl<com.glennbech.usda.model.tables.records.FoodDesRecord> {

	private static final long serialVersionUID = -2023967253;

	/**
	 * The singleton instance of <code>usda.food_des</code>
	 */
	public static final com.glennbech.usda.model.tables.FoodDes FOOD_DES = new com.glennbech.usda.model.tables.FoodDes();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.glennbech.usda.model.tables.records.FoodDesRecord> getRecordType() {
		return com.glennbech.usda.model.tables.records.FoodDesRecord.class;
	}

	/**
	 * The column <code>usda.food_des.NDB_No</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> NDB_NO = createField("NDB_No", org.jooq.impl.SQLDataType.VARCHAR.length(5).nullable(false), this, "");

	/**
	 * The column <code>usda.food_des.FdGrp_Cd</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> FDGRP_CD = createField("FdGrp_Cd", org.jooq.impl.SQLDataType.VARCHAR.length(4), this, "");

	/**
	 * The column <code>usda.food_des.Long_Desc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> LONG_DESC = createField("Long_Desc", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * The column <code>usda.food_des.Shrt_Desc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> SHRT_DESC = createField("Shrt_Desc", org.jooq.impl.SQLDataType.VARCHAR.length(60), this, "");

	/**
	 * The column <code>usda.food_des.ComName</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> COMNAME = createField("ComName", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>usda.food_des.ManufacName</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> MANUFACNAME = createField("ManufacName", org.jooq.impl.SQLDataType.VARCHAR.length(65), this, "");

	/**
	 * The column <code>usda.food_des.Survey</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> SURVEY = createField("Survey", org.jooq.impl.SQLDataType.VARCHAR.length(1), this, "");

	/**
	 * The column <code>usda.food_des.Ref_Desc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> REF_DESC = createField("Ref_Desc", org.jooq.impl.SQLDataType.VARCHAR.length(135), this, "");

	/**
	 * The column <code>usda.food_des.Refuse</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.Integer> REFUSE = createField("Refuse", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>usda.food_des.SciName</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.String> SCINAME = createField("SciName", org.jooq.impl.SQLDataType.VARCHAR.length(65), this, "");

	/**
	 * The column <code>usda.food_des.N_Factor</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.Double> N_FACTOR = createField("N_Factor", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>usda.food_des.Pro_Factor</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.Double> PRO_FACTOR = createField("Pro_Factor", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>usda.food_des.Fat_Factor</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.Double> FAT_FACTOR = createField("Fat_Factor", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>usda.food_des.CHO_Factor</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FoodDesRecord, java.lang.Double> CHO_FACTOR = createField("CHO_Factor", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * Create a <code>usda.food_des</code> table reference
	 */
	public FoodDes() {
		this("food_des", null);
	}

	/**
	 * Create an aliased <code>usda.food_des</code> table reference
	 */
	public FoodDes(java.lang.String alias) {
		this(alias, com.glennbech.usda.model.tables.FoodDes.FOOD_DES);
	}

	private FoodDes(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FoodDesRecord> aliased) {
		this(alias, aliased, null);
	}

	private FoodDes(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FoodDesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.glennbech.usda.model.Usda.USDA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FoodDesRecord> getPrimaryKey() {
		return com.glennbech.usda.model.Keys.KEY_FOOD_DES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FoodDesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.FoodDesRecord>>asList(com.glennbech.usda.model.Keys.KEY_FOOD_DES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.glennbech.usda.model.tables.FoodDes as(java.lang.String alias) {
		return new com.glennbech.usda.model.tables.FoodDes(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.glennbech.usda.model.tables.FoodDes rename(java.lang.String name) {
		return new com.glennbech.usda.model.tables.FoodDes(name, null);
	}
}