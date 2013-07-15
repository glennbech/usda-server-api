package com.glennbech.usda.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 */

@JsonIgnoreProperties(ignoreUnknown = true )

public class FoodItem extends BaseItem  {

    private String ndbNumber;

    private String foodGroup ;
    private String longDescription ;
    private String shortDescription ;

    @XmlElement(nillable=true)
    private String commonName ;

    @XmlElement(nillable=true)
    private String manufacturerName ;

    @XmlElement(nillable=true)
    private boolean survey ;

    @XmlElement(nillable=true)
    private String refuseDescription ;

    @XmlElement(nillable=true)
    private Float refuse;

    @XmlElement(nillable=true)
    private String scientificName ;

    @XmlElement(nillable=true)
    private Float nitrogenFactor ;

    @XmlElement(nillable=true)
    private Float fatFactor ;

    @XmlElement(nillable=true)
    private Float choFactor;

    @XmlElement(nillable=true)
    private Float proteinFactor ;

    @XmlElement(nillable=true)
    private List<Nutrient> nutrients ;

    @XmlElement(nillable=true)
    private List<FootNote> footNotes ;

    @XmlElement(nillable=true)
    private List<WeightData> weightData ;


    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public String getFoodGroup() {
        return foodGroup;
    }


    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
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


}
