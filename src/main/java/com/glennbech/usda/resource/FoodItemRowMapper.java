package com.glennbech.usda.resource;

import com.glennbech.usda.model.FoodItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class FoodItemRowMapper implements RowMapper<FoodItem> {

    public FoodItem mapRow(ResultSet resultSet, int i) throws SQLException {
        FoodItem foodItem = new FoodItem();
        foodItem.setNdbNumber(resultSet.getString("NDB_NO"));
        foodItem.setFoodGroupNumber(resultSet.getString("FDGRP_CD"));
        foodItem.setShortDescription(resultSet.getString("SHRT_DESC"));
        foodItem.setLongDescription(resultSet.getString("LONG_DESC"));
        foodItem.setFoodGroupName(resultSet.getString("FD_GROUP.FDGRP_DESC"));
        foodItem.setCommonName(resultSet.getString("COMNAME"));
        foodItem.setSurvey("Y".equals(resultSet.getString("SURVEY")));
        foodItem.setManufacturerName(resultSet.getString("MANUFACNAME"));
        foodItem.setRefuseDescription(resultSet.getString("REF_DESC"));
        foodItem.setRefuse(resultSet.getFloat("REFUSE"));
        foodItem.setScientificName(resultSet.getString("SCINAME"));
        foodItem.setNitrogenFactor(resultSet.getFloat("N_FACTOR"));
        foodItem.setFatFactor(resultSet.getFloat("FAT_FACTOR"));
        foodItem.setChoFactor(resultSet.getFloat("CHO_FACTOR"));
        foodItem.setProteinFactor(resultSet.getFloat("PRO_FACTOR"));
        return foodItem;
    }
}