package com.glennbech.usda.resource;


import com.glennbech.usda.Constants;
import com.glennbech.usda.model.FoodGroup;
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

        //todo put in
        return Response.ok().build();
    }

}