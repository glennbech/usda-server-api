package com.glennbech.usda.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TopNutrientResponse {

    private String ndbNo ;
    private String longDescription ;
    private float value ;

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
