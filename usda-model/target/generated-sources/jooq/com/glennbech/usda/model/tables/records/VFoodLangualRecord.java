/**
 * This class is generated by jOOQ
 */
package com.glennbech.usda.model.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "v_food_langual", schema = "usda")
public class VFoodLangualRecord extends org.jooq.impl.TableRecordImpl<com.glennbech.usda.model.tables.records.VFoodLangualRecord> implements org.jooq.Record3<java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = 1926995253;

	/**
	 * Setter for <code>usda.v_food_langual.NDB_NO</code>.
	 */
	public void setNdbNo(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>usda.v_food_langual.NDB_NO</code>.
	 */
	@javax.persistence.Column(name = "NDB_NO", length = 5)
	public java.lang.String getNdbNo() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>usda.v_food_langual.FACTOR</code>.
	 */
	public void setFactor(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>usda.v_food_langual.FACTOR</code>.
	 */
	@javax.persistence.Column(name = "FACTOR", nullable = false, length = 6)
	public java.lang.String getFactor() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>usda.v_food_langual.DESCRIPTION</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>usda.v_food_langual.DESCRIPTION</code>.
	 */
	@javax.persistence.Column(name = "DESCRIPTION", length = 250)
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(2);
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
		return com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL.NDB_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL.FACTOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL.DESCRIPTION;
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
		return getFactor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VFoodLangualRecord value1(java.lang.String value) {
		setNdbNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VFoodLangualRecord value2(java.lang.String value) {
		setFactor(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VFoodLangualRecord value3(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VFoodLangualRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached VFoodLangualRecord
	 */
	public VFoodLangualRecord() {
		super(com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL);
	}

	/**
	 * Create a detached, initialised VFoodLangualRecord
	 */
	public VFoodLangualRecord(java.lang.String ndbNo, java.lang.String factor, java.lang.String description) {
		super(com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL);

		setValue(0, ndbNo);
		setValue(1, factor);
		setValue(2, description);
	}
}
