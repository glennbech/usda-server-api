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
public class Weight extends org.jooq.impl.TableImpl<com.glennbech.usda.model.tables.records.WeightRecord> {

	private static final long serialVersionUID = -1737423453;

	/**
	 * The singleton instance of <code>usda.WEIGHT</code>
	 */
	public static final com.glennbech.usda.model.tables.Weight WEIGHT = new com.glennbech.usda.model.tables.Weight();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.glennbech.usda.model.tables.records.WeightRecord> getRecordType() {
		return com.glennbech.usda.model.tables.records.WeightRecord.class;
	}

	/**
	 * The column <code>usda.WEIGHT.NDB_No</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.String> NDB_NO = createField("NDB_No", org.jooq.impl.SQLDataType.VARCHAR.length(5).nullable(false), this, "");

	/**
	 * The column <code>usda.WEIGHT.Seq</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.String> SEQ = createField("Seq", org.jooq.impl.SQLDataType.VARCHAR.length(2).nullable(false), this, "");

	/**
	 * The column <code>usda.WEIGHT.Amount</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.Double> AMOUNT = createField("Amount", org.jooq.impl.SQLDataType.DOUBLE, this, "");

	/**
	 * The column <code>usda.WEIGHT.Msre_Desc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.String> MSRE_DESC = createField("Msre_Desc", org.jooq.impl.SQLDataType.VARCHAR.length(84), this, "");

	/**
	 * The column <code>usda.WEIGHT.Gm_Wgt</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.Double> GM_WGT = createField("Gm_Wgt", org.jooq.impl.SQLDataType.DOUBLE, this, "");

	/**
	 * The column <code>usda.WEIGHT.Num_Data_Pts</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.Integer> NUM_DATA_PTS = createField("Num_Data_Pts", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>usda.WEIGHT.Std_Dev</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.WeightRecord, java.lang.Double> STD_DEV = createField("Std_Dev", org.jooq.impl.SQLDataType.DOUBLE, this, "");

	/**
	 * Create a <code>usda.WEIGHT</code> table reference
	 */
	public Weight() {
		this("WEIGHT", null);
	}

	/**
	 * Create an aliased <code>usda.WEIGHT</code> table reference
	 */
	public Weight(java.lang.String alias) {
		this(alias, com.glennbech.usda.model.tables.Weight.WEIGHT);
	}

	private Weight(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.WeightRecord> aliased) {
		this(alias, aliased, null);
	}

	private Weight(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.WeightRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.glennbech.usda.model.Usda.USDA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.WeightRecord> getPrimaryKey() {
		return com.glennbech.usda.model.Keys.KEY_WEIGHT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.WeightRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.WeightRecord>>asList(com.glennbech.usda.model.Keys.KEY_WEIGHT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.glennbech.usda.model.tables.Weight as(java.lang.String alias) {
		return new com.glennbech.usda.model.tables.Weight(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.glennbech.usda.model.tables.Weight rename(java.lang.String name) {
		return new com.glennbech.usda.model.tables.Weight(name, null);
	}
}
