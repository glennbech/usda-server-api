/**
 * This class is generated by jOOQ
 */
package com.glennbech.usda.model.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "DATSRCLN", schema = "usda", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"NDB_No", "Nutr_No", "DataSrcID"})
})
public class DatsrclnRecord extends org.jooq.impl.UpdatableRecordImpl<com.glennbech.usda.model.tables.records.DatsrclnRecord> implements org.jooq.Record3<java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = 654788583;

	/**
	 * Setter for <code>usda.DATSRCLN.NDB_No</code>.
	 */
	public void setNdbNo(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>usda.DATSRCLN.NDB_No</code>.
	 */
	@javax.persistence.Column(name = "NDB_No", nullable = false, length = 5)
	public java.lang.String getNdbNo() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>usda.DATSRCLN.Nutr_No</code>.
	 */
	public void setNutrNo(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>usda.DATSRCLN.Nutr_No</code>.
	 */
	@javax.persistence.Column(name = "Nutr_No", nullable = false, length = 3)
	public java.lang.String getNutrNo() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>usda.DATSRCLN.DataSrcID</code>.
	 */
	public void setDatasrcid(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>usda.DATSRCLN.DataSrcID</code>.
	 */
	@javax.persistence.Column(name = "DataSrcID", nullable = false, length = 6)
	public java.lang.String getDatasrcid() {
		return (java.lang.String) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record3<java.lang.String, java.lang.String, java.lang.String> key() {
		return (org.jooq.Record3) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.glennbech.usda.model.tables.Datsrcln.DATSRCLN.NDB_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.glennbech.usda.model.tables.Datsrcln.DATSRCLN.NUTR_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.glennbech.usda.model.tables.Datsrcln.DATSRCLN.DATASRCID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getNdbNo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getNutrNo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getDatasrcid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatsrclnRecord value1(java.lang.String value) {
		setNdbNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatsrclnRecord value2(java.lang.String value) {
		setNutrNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatsrclnRecord value3(java.lang.String value) {
		setDatasrcid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatsrclnRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DatsrclnRecord
	 */
	public DatsrclnRecord() {
		super(com.glennbech.usda.model.tables.Datsrcln.DATSRCLN);
	}

	/**
	 * Create a detached, initialised DatsrclnRecord
	 */
	public DatsrclnRecord(java.lang.String ndbNo, java.lang.String nutrNo, java.lang.String datasrcid) {
		super(com.glennbech.usda.model.tables.Datsrcln.DATSRCLN);

		setValue(0, ndbNo);
		setValue(1, nutrNo);
		setValue(2, datasrcid);
	}
}
