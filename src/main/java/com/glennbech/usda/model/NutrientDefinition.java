package com.glennbech.usda.model;

/**
 *
 */
public class NutrientDefinition extends BaseItem {

    private String nutrientNumber ;
    private String units ;
    private String tagName ;
    private String  nutrientDescription ;
    private Integer  roundedToDecimalPoint;
    private Integer standardReferenceOrder ;

    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getNutrientDescription() {
        return nutrientDescription;
    }

    public void setNutrientDescription(String nutrientDescription) {
        this.nutrientDescription = nutrientDescription;
    }

    public Integer getRoundedToDecimalPoint() {
        return roundedToDecimalPoint;
    }

    public void setRoundedToDecimalPoint(Integer roundedToDecimalPoint) {
        this.roundedToDecimalPoint = roundedToDecimalPoint;
    }

    public Integer getStandardReferenceOrder() {
        return standardReferenceOrder;
    }

    public void setStandardReferenceOrder(Integer standardReferenceOrder) {
        this.standardReferenceOrder = standardReferenceOrder;
    }

}
