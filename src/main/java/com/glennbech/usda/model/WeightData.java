package com.glennbech.usda.model;

/**
 *
 */
public class WeightData {


    private int sequenceNumber ;
    private String measureDescription;
    private float amount ;
    private float gramweight;
    private int datapoints;
    private float standardDeviation ;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getMeasureDescription() {
        return measureDescription;
    }

    public void setMeasureDescription(String measureDescription) {
        this.measureDescription = measureDescription;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getGramweight() {
        return gramweight;
    }

    public void setGramweight(float gramweight) {
        this.gramweight = gramweight;
    }

    public int getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(int datapoints) {
        this.datapoints = datapoints;
    }

    public float getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(float standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}
