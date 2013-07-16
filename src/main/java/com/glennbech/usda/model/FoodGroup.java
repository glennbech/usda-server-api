package com.glennbech.usda.model;

import java.util.List;

/**
 *
 */
public class FoodGroup extends BaseItem {

    private String foodGroupNumber;
    private String name ;
    private List<String> ndbNumbers ;
    private int count ;

    public String getFoodGroupNumber() {
        return foodGroupNumber;
    }

    public void setFoodGroupNumber(String foodGroupNumber) {
        this.foodGroupNumber = foodGroupNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNdbNumbers() {
        return ndbNumbers;
    }

    public void setNdbNumbers(List<String> ndbNumbers) {
        this.ndbNumbers = ndbNumbers;
    }

    public int count() {
        return ndbNumbers.size();
    }

}
