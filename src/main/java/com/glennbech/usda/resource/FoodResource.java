package com.glennbech.usda.resource;


import com.glennbech.usda.model.FoodItem;
import com.glennbech.usda.model.Nutrient;
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

@Path("/food")
public class FoodResource extends BaseResource {

    @GET
    @Produces("application/json")
    @Path("/{ndb_no}")
    public Response getFoodByIdentifier(@PathParam("ndb_no") final String ndbNo, @QueryParam(value = "nutrients") boolean nutrients) throws IOException {

        FoodItem item = getJdbcTemplate().queryForObject("SELECT * FROM FOOD_DES, FD_GROUP WHERE FOOD_DES.NDB_NO = ? AND FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD", new String[]{ndbNo}, new FoodItemRowMapper());
        if (nutrients) {
            List<Nutrient> nutrientList = getJdbcTemplate().query("SELECT nutr_desc, nutr_val, units FROM NUT_DATA, NUTR_DEF WHERE nut_data.NUTR_NO = nutr_def.NUTR_NO AND ndb_no = ? ORDER BY sr_order ASC", new String[]{ndbNo}, new RowMapper<Nutrient>() {
                @Override
                public Nutrient mapRow(ResultSet resultSet, int i) throws SQLException {
                    Nutrient nutrient = new Nutrient();
                    nutrient.setDescription(resultSet.getString("nutr_desc"));
                    nutrient.setUnits(resultSet.getString("units"));
                    nutrient.setValue(resultSet.getFloat("nutr_val"));
                    return nutrient;
                }
            });
            item.setNutrients(nutrientList);
        }
        if (item != null)
            return Response.ok(item).build();
        else
            return Response.status(400).build();
    }

    @GET
    @Produces("application/json")
    @Path("/search/{criteria}")
    public Response search(@PathParam("criteria") String criteria) {

        Response response;

        if (criteria == null || criteria.length() < 3) {
            response = Response.status(400).entity("Search critera must be at least 3 characters").build();
        } else {
            List<FoodItem> results = getJdbcTemplate().query("SELECT * FROM FOOD_DES WHERE match (long_desc, shrt_desc, comname, SCINAME, MANUFACNAME) against (?) LIMIT ?", new Object[]{criteria , 10}, new FoodItemRowMapper());
            response = Response.ok(results).build();
        }
        return response;
    }

    private static class FoodItemRowMapper implements RowMapper<FoodItem> {
        @Override
        public FoodItem mapRow(ResultSet resultSet, int i) throws SQLException {
            FoodItem foodItem = new FoodItem();
            foodItem.setNdbNumber(resultSet.getString("NDB_NO"));
            foodItem.setFoodGroup(resultSet.getString("FDGRP_CD"));
            foodItem.setShortDescription(resultSet.getString("SHRT_DESC"));
            foodItem.setLongDescription(resultSet.getString("LONG_DESC"));
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