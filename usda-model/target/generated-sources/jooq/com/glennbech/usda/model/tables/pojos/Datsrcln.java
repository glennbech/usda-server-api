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
@javax.persistence.Table(name = "DATSRCLN", schema = "usda", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"NDB_No", "Nutr_No", "DataSrcID"})
})
public class Datsrcln implements java.io.Serializable {

	private static final long serialVersionUID = -49912951;

	private java.lang.String ndbNo;
	private java.lang.String nutrNo;
	private java.lang.String datasrcid;

	public Datsrcln() {}

	public Datsrcln(
		java.lang.String ndbNo,
		java.lang.String nutrNo,
		java.lang.String datasrcid
	) {
		this.ndbNo = ndbNo;
		this.nutrNo = nutrNo;
		this.datasrcid = datasrcid;
	}

	@javax.persistence.Column(name = "NDB_No", nullable = false, length = 5)
	public java.lang.String getNdbNo() {
		return this.ndbNo;
	}

	public void setNdbNo(java.lang.String ndbNo) {
		this.ndbNo = ndbNo;
	}

	@javax.persistence.Column(name = "Nutr_No", nullable = false, length = 3)
	public java.lang.String getNutrNo() {
		return this.nutrNo;
	}

	public void setNutrNo(java.lang.String nutrNo) {
		this.nutrNo = nutrNo;
	}

	@javax.persistence.Column(name = "DataSrcID", nullable = false, length = 6)
	public java.lang.String getDatasrcid() {
		return this.datasrcid;
	}

	public void setDatasrcid(java.lang.String datasrcid) {
		this.datasrcid = datasrcid;
	}
}