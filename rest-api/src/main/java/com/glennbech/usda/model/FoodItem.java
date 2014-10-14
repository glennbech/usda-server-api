package com.glennbech.usda.model;

import com.glennbech.usda.model.tables.pojos.VFoodNutrient;
import com.glennbech.usda.model.tables.pojos.FoodDes;
import com.glennbech.usda.model.tables.pojos.VFoodLangual;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class FoodItem extends BaseItem {

    private FoodDes foodInfo;
    private List<VFoodNutrient> nutrition;
    private List<VFoodLangual> langualMeta;
    private List<WeightData> weightData;

    public FoodItem() {
    }

    public FoodDes getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(FoodDes foodInfo) {
        this.foodInfo = foodInfo;
    }

    public List<VFoodNutrient> getNutrition() {
        return nutrition;
    }

    public void setNutrition(List<VFoodNutrient> nutrition) {
        this.nutrition = nutrition;
    }

    public List<VFoodLangual> getLangualMeta() {
        return langualMeta;
    }

    public void setLangualMeta(List<VFoodLangual> langualMeta) {
        this.langualMeta = langualMeta;
    }

    public List<WeightData> getWeightData() {
        return weightData;
    }

    public void setWeightData(List<WeightData> weightData) {
        this.weightData = weightData;
    }


}
