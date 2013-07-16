package com.glennbech.usda.model;

/**
 *
 */
public class NutrientValue {

    private String description ;
    private float value ;
    private String units;

    public NutrientValue() {
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
