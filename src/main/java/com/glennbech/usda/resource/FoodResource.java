package com.glennbech.usda.resource;


import com.glennbech.usda.model.FoodItem;
import com.glennbech.usda.model.NutrientValue;
import com.glennbech.usda.model.SearchResult;
import com.glennbech.usda.model.WeightData;
import org.springframework.jdbc.core.RowMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */

@Path("/fooditems")
public class FoodResource extends BaseResource {

    @GET
    @Produces("application/json")
    @Path("/{ndb_no}")
    public Response getFoodByIdentifier(@PathParam("ndb_no") final String ndbNo, @QueryParam(value = "nutrients") boolean nutrients, @QueryParam(value = "weight") boolean weight) throws IOException {

        Response response;

        List<FoodItem> items = getJdbcTemplate().query("SELECT * FROM FOOD_DES, FD_GROUP WHERE FOOD_DES.NDB_NO = ? AND FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD", new String[]{ndbNo}, new FoodItemRowMapper());
        if (items.size() == 0) {
            response = Response.status(Response.Status.NOT_FOUND).entity("No food item with ndbNumber" + ndbNo + " found").build();

        } else {
            FoodItem item = items.get(0);
            if (nutrients) {
                List<NutrientValue> nutrientList = getJdbcTemplate().query("SELECT nutr_desc, nutr_val, units FROM NUT_DATA, NUTR_DEF WHERE NUT_DATA.NUTR_NO = NUTR_DEF.NUTR_NO AND ndb_no = ? ORDER BY sr_order ASC", new String[]{ndbNo}, new RowMapper<NutrientValue>() {
                    @Override
                    public NutrientValue mapRow(ResultSet resultSet, int i) throws SQLException {
                        NutrientValue nutrient = new NutrientValue();
                        nutrient.setDescription(resultSet.getString("nutr_desc"));
                        nutrient.setUnits(resultSet.getString("units"));
                        nutrient.setValue(resultSet.getFloat("nutr_val"));
                        return nutrient;
                    }
                });
                item.setNutrients(nutrientList);
            }

            if (weight) {
                List<WeightData> weightData = getJdbcTemplate().query("SELECT * FROM WEIGHT WHERE NDB_NO = ? ", new String[]{ndbNo}, new RowMapper<WeightData>() {
                    @Override
                    public WeightData mapRow(ResultSet resultSet, int i) throws SQLException {
                        WeightData data = new WeightData();
                        data.setAmount(resultSet.getFloat("AMOUNT"));
                        data.setDatapoints(resultSet.getInt("NUM_DATA_PTS"));
                        data.setGramweight(resultSet.getFloat("GM_WGT"));
                        data.setMeasureDescription(resultSet.getString("MSRE_DESC"));
                        data.setSequenceNumber(resultSet.getInt("SEQ"));
                        data.setStandardDeviation(resultSet.getFloat("STD_DEV"));
                        return data;
                    }
                });
                item.setWeightData(weightData);
            }
            response = Response.ok().entity(item).build();
        }
        return response;
    }

    @GET
    @Produces("application/json")
    @Path("/search/{criteria}")
    public Response search(@PathParam("criteria") String criteria, @QueryParam("page") Integer page, @QueryParam("pagesize") Integer pagesize) {

        Response response;

        pagesize = (pagesize == null) ? 10 : pagesize;
        page = (page == null) ? 0 : page;

        if (pagesize > 50) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please use a pagesize of 50 or below").build();
        }

        if (criteria == null || criteria.length() < 3) {
            response = Response.status(400).entity("Search critera must be at least 3 characters").build();
        } else {
            Integer count = getJdbcTemplate().queryForInt("SELECT count(*) FROM FOOD_DES WHERE match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) ", new Object[]{criteria});
            List<FoodItem> foodItems = getJdbcTemplate().query("SELECT * FROM FOOD_DES,FD_GROUP WHERE FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD and match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) LIMIT ?,?", new Object[]{criteria, page * pagesize, pagesize}, new FoodItemRowMapper());
            SearchResult<FoodItem> result = new SearchResult<FoodItem>();
            result.setResults(foodItems);
            result.setTotalResults(count);
            result.setCurrentPage(page);
            result.setPageSize(pagesize);
            response = Response.ok(result).build();
        }
        return response;
    }

    private static class FoodItemRowMapper implements RowMapper<FoodItem> {
        @Override
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

}