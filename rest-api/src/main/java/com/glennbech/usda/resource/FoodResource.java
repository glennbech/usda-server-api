package com.glennbech.usda.resource;


import com.glennbech.usda.Constants;
import com.glennbech.usda.model.*;
import com.glennbech.usda.model.tables.pojos.VFoodLangual;
import com.glennbech.usda.model.tables.pojos.FoodDes;
import com.glennbech.usda.model.tables.pojos.VFoodNutrient;
import org.springframework.jdbc.core.RowMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.glennbech.usda.Constants.MAX_PAGE_SIZE;
import static com.glennbech.usda.Constants.MIN_SEARCH_CHARS;
import static com.glennbech.usda.model.Tables.*;

import static com.glennbech.usda.model.Tables.V_FOOD_LANGUAL;


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
    public Response getFoodByIdentifier(@PathParam("ndbNumber") final String ndbNo, @QueryParam(value = "nutrients") boolean nutrients, @QueryParam(value = "langual") boolean langual, @QueryParam(value = "weight") boolean weight) throws IOException {

        Response response;

        FoodItem resultItem = new FoodItem();


        FoodDes item = getContext().select().from(FOOD_DES).join(FD_GROUP).on(FD_GROUP.FDGRP_CD.equal(FOOD_DES.FDGRP_CD)).where(FOOD_DES.NDB_NO.eq(ndbNo)).fetchAnyInto(com.glennbech.usda.model.tables.pojos.FoodDes.class);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No food item with ndbNumber" + ndbNo + " found").build();
        }
        resultItem.setFoodInfo(item);

        if (langual) {
            List<VFoodLangual> langualMeta =
                    getContext().select().from(V_FOOD_LANGUAL).where(V_FOOD_LANGUAL.NDB_NO.eq(ndbNo)).fetchInto(VFoodLangual.class);

            resultItem.setLangualMeta(langualMeta);
        }
        if (nutrients) {
            List<VFoodNutrient> foodNutrients = getContext().select().from(V_FOOD_NUTRIENT).where(Tables.V_FOOD_NUTRIENT.NDB_NO.eq(ndbNo)).fetchInto(VFoodNutrient.class);
            resultItem.setNutrition(foodNutrients);
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
        }
        return Response.ok().entity(resultItem).build();
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

        SearchResult<FoodItem> result = new SearchResult<FoodItem>();
        result.setTotalResults(count);
        result.setCurrentPage(page);
        result.setPageSize(pagesize);
        response = Response.ok(result).build();
        return response;
    }

}