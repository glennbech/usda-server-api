package com.glennbech.usda.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 */

@JsonIgnoreProperties(ignoreUnknown = true )
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class FoodItem extends BaseItem  {

    private String ndbNumber;

    private String foodGroupNumber;
    private String foodGroupName;

    private String longDescription ;
    private String shortDescription ;

    private String commonName ;

    private String manufacturerName ;

    private boolean survey ;

    private String refuseDescription ;

    private Float refuse;

    private String scientificName ;

    private Float nitrogenFactor ;

    private Float fatFactor ;

    private Float choFactor;

    private Float proteinFactor ;

    private List<NutrientValue> nutrients ;

    private List<FootNote> footNotes ;

    private List<WeightData> weights;

    public String getFoodGroupName() {
        return foodGroupName;
    }

    public void setFoodGroupName(String foodGroupName) {
        this.foodGroupName = foodGroupName;
    }

    public List<NutrientValue> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<NutrientValue> nutrients) {
        this.nutrients = nutrients;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public String getFoodGroupNumber() {
        return foodGroupNumber;
    }


    public void setFoodGroupNumber(String foodGroupNumber) {
        this.foodGroupNumber = foodGroupNumber;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public boolean isSurvey() {
        return survey;
    }

    public void setSurvey(boolean survey) {
        this.survey = survey;
    }

    public String getRefuseDescription() {
        return refuseDescription;
    }

    public void setRefuseDescription(String refuseDescription) {
        this.refuseDescription = refuseDescription;
    }

    public Float getRefuse() {
        return refuse;
    }

    public void setRefuse(Float refuse) {
        this.refuse = refuse;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Float getNitrogenFactor() {
        return nitrogenFactor;
    }

    public void setNitrogenFactor(Float nitrogenFactor) {
        this.nitrogenFactor = nitrogenFactor;
    }

    public Float getFatFactor() {
        return fatFactor;
    }

    public void setFatFactor(Float fatFactor) {
        this.fatFactor = fatFactor;
    }

    public Float getChoFactor() {
        return choFactor;
    }

    public void setChoFactor(Float choFactor) {
        this.choFactor = choFactor;
    }

    public Float getProteinFactor() {
        return proteinFactor;
    }

    public void setProteinFactor(Float proteinFactor) {
        this.proteinFactor = proteinFactor;
    }

    public List<WeightData> getWeight() {
        return weights;
    }

    public void setWeight(List<WeightData> weights) {
        this.weights = weights;
    }
}
