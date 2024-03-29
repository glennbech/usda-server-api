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
public class Footnote extends org.jooq.impl.TableImpl<com.glennbech.usda.model.tables.records.FootnoteRecord> {

	private static final long serialVersionUID = -2046653976;

	/**
	 * The singleton instance of <code>usda.FOOTNOTE</code>
	 */
	public static final com.glennbech.usda.model.tables.Footnote FOOTNOTE = new com.glennbech.usda.model.tables.Footnote();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.glennbech.usda.model.tables.records.FootnoteRecord> getRecordType() {
		return com.glennbech.usda.model.tables.records.FootnoteRecord.class;
	}

	/**
	 * The column <code>usda.FOOTNOTE.NDB_NO</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FootnoteRecord, java.lang.String> NDB_NO = createField("NDB_NO", org.jooq.impl.SQLDataType.VARCHAR.length(5), this, "");

	/**
	 * The column <code>usda.FOOTNOTE.Footnt_No</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FootnoteRecord, java.lang.String> FOOTNT_NO = createField("Footnt_No", org.jooq.impl.SQLDataType.VARCHAR.length(4), this, "");

	/**
	 * The column <code>usda.FOOTNOTE.Footnot_Typ</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FootnoteRecord, java.lang.String> FOOTNOT_TYP = createField("Footnot_Typ", org.jooq.impl.SQLDataType.VARCHAR.length(1), this, "");

	/**
	 * The column <code>usda.FOOTNOTE.Nutr_No</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FootnoteRecord, java.lang.String> NUTR_NO = createField("Nutr_No", org.jooq.impl.SQLDataType.VARCHAR.length(3), this, "");

	/**
	 * The column <code>usda.FOOTNOTE.Footnot_Txt</code>.
	 */
	public final org.jooq.TableField<com.glennbech.usda.model.tables.records.FootnoteRecord, java.lang.String> FOOTNOT_TXT = createField("Footnot_Txt", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * Create a <code>usda.FOOTNOTE</code> table reference
	 */
	public Footnote() {
		this("FOOTNOTE", null);
	}

	/**
	 * Create an aliased <code>usda.FOOTNOTE</code> table reference
	 */
	public Footnote(java.lang.String alias) {
		this(alias, com.glennbech.usda.model.tables.Footnote.FOOTNOTE);
	}

	private Footnote(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FootnoteRecord> aliased) {
		this(alias, aliased, null);
	}

	private Footnote(java.lang.String alias, org.jooq.Table<com.glennbech.usda.model.tables.records.FootnoteRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.glennbech.usda.model.Usda.USDA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.glennbech.usda.model.tables.Footnote as(java.lang.String alias) {
		return new com.glennbech.usda.model.tables.Footnote(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.glennbech.usda.model.tables.Footnote rename(java.lang.String name) {
		return new com.glennbech.usda.model.tables.Footnote(name, null);
	}
}
