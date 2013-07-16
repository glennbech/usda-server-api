package com.glennbech.usda.resource;


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

@Path("/foodgroups")
public class FoodGroupResource extends BaseResource {

    @GET
    @Produces("application/json")
    public Response getFoodGroups() throws IOException {

        List<FoodGroup> foodGroups = getJdbcTemplate().query("select fd_group.fdgrp_cd, fdgrp_desc, count(*) as 'count' from food_des, fd_group where food_des.fdgrp_cd = fd_group.fdgrp_cd group by fdgrp_desc order by count desc", new RowMapper<FoodGroup>() {
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

}