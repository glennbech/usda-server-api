/**
 * This class is generated by jOOQ
 */
package com.glennbech.usda.model.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "LANGDESC", schema = "usda")
public class Langdesc implements java.io.Serializable {

	private static final long serialVersionUID = -1115645488;

	private java.lang.String factor;
	private java.lang.String description;

	public Langdesc() {}

	public Langdesc(
		java.lang.String factor,
		java.lang.String description
	) {
		this.factor = factor;
		this.description = description;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "Factor", unique = true, nullable = false, length = 6)
	public java.lang.String getFactor() {
		return this.factor;
	}

	public void setFactor(java.lang.String factor) {
		this.factor = factor;
	}

	@javax.persistence.Column(name = "Description", length = 250)
	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
}
