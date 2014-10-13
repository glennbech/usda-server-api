package com.glennbech.usda.resource;


import com.glennbech.usda.Constants;
import com.glennbech.usda.model.FoodGroup;
import com.glennbech.usda.model.FoodItem;
import com.glennbech.usda.model.SearchResult;
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

@Path("/foodgroup")
public class FoodGroupResource extends BaseResource {

    @GET
    @Produces("application/json")
    public Response getFoodGroups() throws IOException {

        List<FoodGroup> foodGroups = getJdbcTemplate().query("select FD_GROUP.fdgrp_cd, fdgrp_desc, count(*) as 'count' from FOOD_DES, FD_GROUP where FOOD_DES.fdgrp_cd = FD_GROUP.fdgrp_cd group by fdgrp_desc order by count desc", new RowMapper<FoodGroup>() {
            @Override
            public FoodGroup mapRow(ResultSet resultSet, int i) throws SQLException {
                FoodGroup group = new FoodGroup();
                group.setFoodGroupNumber(resultSet.getString("FDGRP_CD"));
                group.setName(resultSet.getString("FDGRP_DESC"));
                group.setCount(resultSet.getInt("count"));
                return group;
            }
        });
        return Response.ok().entity(foodGroups).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{foodGroupNumber}")
    public Response getFoodsByFoodGroup(@PathParam("foodGroupNumber") String foodGroupNumber, @QueryParam("page") Integer page, @QueryParam("pageSize") Integer pageSize) throws IOException {

        pageSize = (pageSize == null) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        page = (page == null) ? 0 : page;

        if (pageSize > Constants.MAX_PAGE_SIZE) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please use a pagesize of 50 or below").build();
        }

        final String countSQL= "select count(*) from FOOD_DES where FOOD_DES.FDGRP_CD = ?" ;
        final String[] countArguments = new String[] {foodGroupNumber} ;
        final String querySQL = "select * FROM FOOD_DES, FD_GROUP where FOOD_DES.FDGRP_CD = ? AND FOOD_DES.FDGRP_CD = FD_GROUP.FDGRP_CD LIMIT ?,?";
        final Object[] quryArguments = new Object[] {foodGroupNumber, page * pageSize, pageSize} ;

        PagedQuery <FoodItem> foodItemsQuery = new PagedQuery<FoodItem>(getJdbcTemplate());
        SearchResult<FoodItem> items = foodItemsQuery.query(countSQL, countArguments, querySQL, quryArguments, new FoodItemRowMapper(), pageSize, page);
        return Response.ok().entity(items).build();
    }

}