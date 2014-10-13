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
public class NutrDef extends org.jooq.impl.TableImpl<com.glennbech.usda.model.tables.records.NutrDefRecord> {

	private static final long serialVersionUID = 2102218000;

	/**
	 * The singleton instance of <code>usda.NUTR_DEF</code>
	 */
	public static final com.glennbech.usda.model.tables.NutrDef NUTR_DEF = new com.glennbech.usda.model.tables.NutrDef();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.glennbech.usda.model.tables.records.NutrDefRecord> getRecordType() {
		return com.glennbech.usda.model.tables.records.NutrDefRecord.class;
	}

	/**
	 * The column <code>usda.NUTR_DEF.Nutr_No</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.String> NUTR_NO = createField("Nutr_No", org.jooq.impl.SQLDataType.VARCHAR.length(3).nullable(false), this, "");

	/**
	 * The column <code>usda.NUTR_DEF.Units</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.String> UNITS = createField("Units", org.jooq.impl.SQLDataType.VARCHAR.length(7), this, "");

	/**
	 * The column <code>usda.NUTR_DEF.Tagname</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.String> TAGNAME = createField("Tagname", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

	/**
	 * The column <code>usda.NUTR_DEF.NutrDesc</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.String> NUTRDESC = createField("NutrDesc", org.jooq.impl.SQLDataType.VARCHAR.length(60), this, "");

	/**
	 * The column <code>usda.NUTR_DEF.Num_Dec</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.String> NUM_DEC = createField("Num_Dec", org.jooq.impl.SQLDataType.VARCHAR.length(1), this, "");

	/**
	 * The column <code>usda.NUTR_DEF.SR_Order</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.NutrDefRecord, java.lang.Double> SR_ORDER = createField("SR_Order", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * Create a <code>usda.NUTR_DEF</code> table reference
	 */
	public NutrDef() {
		this("NUTR_DEF", null);
	}

	/**
	 * Create an aliased <code>usda.NUTR_DEF</code> table reference
	 */
	public NutrDef(java.lang.String alias) {
		this(alias, com.glennbech.usda.model.tables.NutrDef.NUTR_DEF);
	}

	private NutrDef(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.NutrDefRecord> aliased) {
		this(alias, aliased, null);
	}

	private NutrDef(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.NutrDefRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.glennbech.usda.model.Usda.USDA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.NutrDefRecord> getPrimaryKey() {
		return com.glennbech.usda.model.Keys.KEY_NUTR_DEF_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.NutrDefRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.glennbech.usda.model.tables.records.NutrDefRecord>>asList(com.glennbech.usda.model.Keys.KEY_NUTR_DEF_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.glennbech.usda.model.tables.NutrDef as(java.lang.String alias) {
		return new com.glennbech.usda.model.tables.NutrDef(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.glennbech.usda.model.tables.NutrDef rename(java.lang.String name) {
		return new com.glennbech.usda.model.tables.NutrDef(name, null);
	}
}