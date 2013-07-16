package com.glennbech.usda.model;

/**
 *
 */
public class NutrientDefinition extends BaseItem {

    private String nutrientNumber ;
    private String units ;
    private String tagName ;
    private String  nutrientDescription ;
    private int roundedToDecimalPoint;
    private int standardReferenceOrder ;

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

    public int getRoundedToDecimalPoint() {
        return roundedToDecimalPoint;
    }

    public void setRoundedToDecimalPoint(int roundedToDecimalPoint) {
        this.roundedToDecimalPoint = roundedToDecimalPoint;
    }

    public int getStandardReferenceOrder() {
        return standardReferenceOrder;
    }

    public void setStandardReferenceOrder(int standardReferenceOrder) {
        this.standardReferenceOrder = standardReferenceOrder;
    }
}
