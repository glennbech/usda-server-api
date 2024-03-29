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
@javax.persistence.Table(name = "WEIGHT", schema = "usda", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"NDB_No", "Seq"})
})
public class WeightRecord extends org.jooq.impl.UpdatableRecordImpl<com.glennbech.usda.model.tables.records.WeightRecord> implements org.jooq.Record7<java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.Double> {

	private static final long serialVersionUID = 826289144;

	/**
	 * Setter for <code>usda.WEIGHT.NDB_No</code>.
	 */
	public void setNdbNo(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.NDB_No</code>.
	 */
	@javax.persistence.Column(name = "NDB_No", nullable = false, length = 5)
	public java.lang.String getNdbNo() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Seq</code>.
	 */
	public void setSeq(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Seq</code>.
	 */
	@javax.persistence.Column(name = "Seq", nullable = false, length = 2)
	public java.lang.String getSeq() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Amount</code>.
	 */
	public void setAmount(java.lang.Double value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Amount</code>.
	 */
	@javax.persistence.Column(name = "Amount", precision = 22)
	public java.lang.Double getAmount() {
		return (java.lang.Double) getValue(2);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Msre_Desc</code>.
	 */
	public void setMsreDesc(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Msre_Desc</code>.
	 */
	@javax.persistence.Column(name = "Msre_Desc", length = 84)
	public java.lang.String getMsreDesc() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Gm_Wgt</code>.
	 */
	public void setGmWgt(java.lang.Double value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Gm_Wgt</code>.
	 */
	@javax.persistence.Column(name = "Gm_Wgt", precision = 22)
	public java.lang.Double getGmWgt() {
		return (java.lang.Double) getValue(4);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Num_Data_Pts</code>.
	 */
	public void setNumDataPts(java.lang.Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Num_Data_Pts</code>.
	 */
	@javax.persistence.Column(name = "Num_Data_Pts", precision = 10)
	public java.lang.Integer getNumDataPts() {
		return (java.lang.Integer) getValue(5);
	}

	/**
	 * Setter for <code>usda.WEIGHT.Std_Dev</code>.
	 */
	public void setStdDev(java.lang.Double value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>usda.WEIGHT.Std_Dev</code>.
	 */
	@javax.persistence.Column(name = "Std_Dev", precision = 22)
	public java.lang.Double getStdDev() {
		return (java.lang.Double) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record2<java.lang.String, java.lang.String> key() {
		return (org.jooq.Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.Double> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.Double> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.NDB_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.SEQ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field3() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.AMOUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.MSRE_DESC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field5() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.GM_WGT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field6() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.NUM_DATA_PTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Double> field7() {
		return com.glennbech.usda.model.tables.Weight.WEIGHT.STD_DEV;
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
		return getSeq();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value3() {
		return getAmount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getMsreDesc();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value5() {
		return getGmWgt();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value6() {
		return getNumDataPts();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Double value7() {
		return getStdDev();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value1(java.lang.String value) {
		setNdbNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value2(java.lang.String value) {
		setSeq(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value3(java.lang.Double value) {
		setAmount(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value4(java.lang.String value) {
		setMsreDesc(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value5(java.lang.Double value) {
		setGmWgt(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value6(java.lang.Integer value) {
		setNumDataPts(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord value7(java.lang.Double value) {
		setStdDev(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WeightRecord values(java.lang.String value1, java.lang.String value2, java.lang.Double value3, java.lang.String value4, java.lang.Double value5, java.lang.Integer value6, java.lang.Double value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached WeightRecord
	 */
	public WeightRecord() {
		super(com.glennbech.usda.model.tables.Weight.WEIGHT);
	}

	/**
	 * Create a detached, initialised WeightRecord
	 */
	public WeightRecord(java.lang.String ndbNo, java.lang.String seq, java.lang.Double amount, java.lang.String msreDesc, java.lang.Double gmWgt, java.lang.Integer numDataPts, java.lang.Double stdDev) {
		super(com.glennbech.usda.model.tables.Weight.WEIGHT);

		setValue(0, ndbNo);
		setValue(1, seq);
		setValue(2, amount);
		setValue(3, msreDesc);
		setValue(4, gmWgt);
		setValue(5, numDataPts);
		setValue(6, stdDev);
	}
}
