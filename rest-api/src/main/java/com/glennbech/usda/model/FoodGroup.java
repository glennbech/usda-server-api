package com.glennbech.usda.model;

/**
 *
 */
public class FoodGroup extends BaseItem {

    private String foodGroupNumber;
    private String name ;
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

}
