package com.glennbech.usda.resource;


import com.glennbech.usda.Constants;
import com.glennbech.usda.model.*;
import org.springframework.jdbc.core.RowMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.glennbech.usda.Constants.MAX_PAGE_SIZE;
import static com.glennbech.usda.Constants.MIN_SEARCH_CHARS;

/**
 *
 */

@Path("/fooditem")
public class FoodResource extends BaseResource {


    @GET
    @Produces("application/json")
    @Path("{ndbNumber}/similar_key_vitamin_minerals")
    public Response getSimilarFoods(@PathParam("ndbNumber") final String ndbNo) {
        SimilarFoods foods = SimilarFoods.instance();
        List<String> similar = foods.getSimilarItems(ndbNo);

        SimilarFoodsResult result = new SimilarFoodsResult(similar);
        return Response.ok().entity(result).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{ndbNumber}")
    public Response getFoodByIdentifier(@PathParam("ndbNumber") final String ndbNo, @QueryParam(value = "nutrients") boolean nutrients, @QueryParam(value = "weight") boolean weight) throws IOException {

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
                item.setWeight(weightData);
            }
            response = Response.ok().entity(item).build();
        }
        return response;
    }

    @GET
    @Produces("application/json")
    @Path("/search/{criteria}")
    public Response search(@PathParam("criteria") String criteria, @QueryParam("page") Integer page, @QueryParam("pageSize") Integer pagesize, @QueryParam("foodGroup") String foodGroup) {

        Response response;

        pagesize = (pagesize == null) ? Constants.DEFAULT_PAGE_SIZE : pagesize;
        page = (page == null) ? 0 : page;

        if (pagesize > MAX_PAGE_SIZE) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please use a pagesize of 50 or below").build();
        }

        if (criteria == null || criteria.length() < MIN_SEARCH_CHARS) {
            return Response.status(400).entity("Search critera must be at least 3 characters").build();
        }

        Integer count;
        String query;
        Object[] arguments;

        if (foodGroup != null) {
            count = getJdbcTemplate().queryForInt("SELECT count(*) FROM FOOD_DES WHERE match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) and fdgrp_cd = ? ", new Object[]{criteria, foodGroup});
            query = "SELECT * FROM FOOD_DES,FD_GROUP WHERE FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD and match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) and FOOD_DES.fdgrp_cd = ?  LIMIT ?,?";
            arguments = new Object[]{criteria, foodGroup, page * pagesize, pagesize};

        } else {
            count = getJdbcTemplate().queryForInt("SELECT count(*) FROM FOOD_DES WHERE match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) ", new Object[]{criteria});
            query = "SELECT * FROM FOOD_DES,FD_GROUP WHERE FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD and match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) LIMIT ?,?";
            arguments = new Object[]{criteria, page * pagesize, pagesize};
        }

        List<FoodItem> foodItems = getJdbcTemplate().query(query, arguments, new FoodItemRowMapper());
        SearchResult<FoodItem> result = new SearchResult<FoodItem>();
        result.setResults(foodItems);
        result.setTotalResults(count);
        result.setCurrentPage(page);
        result.setPageSize(pagesize);
        response = Response.ok(result).build();
        return response;
    }

}