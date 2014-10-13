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
@javax.persistence.Table(name = "FD_GROUP", schema = "usda")
public class FdGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1476922107;

	private java.lang.String fdgrpCd;
	private java.lang.String fdgrpDesc;

	public FdGroup() {}

	public FdGroup(
		java.lang.String fdgrpCd,
		java.lang.String fdgrpDesc
	) {
		this.fdgrpCd = fdgrpCd;
		this.fdgrpDesc = fdgrpDesc;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "FdGrp_CD", unique = true, nullable = false, length = 4)
	public java.lang.String getFdgrpCd() {
		return this.fdgrpCd;
	}

	public void setFdgrpCd(java.lang.String fdgrpCd) {
		this.fdgrpCd = fdgrpCd;
	}

	@javax.persistence.Column(name = "FdGrp_Desc", length = 60)
	public java.lang.String getFdgrpDesc() {
		return this.fdgrpDesc;
	}

	public void setFdgrpDesc(java.lang.String fdgrpDesc) {
		this.fdgrpDesc = fdgrpDesc;
	}
}
