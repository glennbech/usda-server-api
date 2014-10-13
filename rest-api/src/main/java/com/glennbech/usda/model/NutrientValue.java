package com.glennbech.usda.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class NutrientValue {

    private String order;
    private String description;
    private float value;
    private String units;
    private String nutrientNo;

    public NutrientValue() {
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getNutrientNo() {
        return nutrientNo;
    }

    public void setNutrientNo(String nutrientNo) {
        this.nutrientNo = nutrientNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
