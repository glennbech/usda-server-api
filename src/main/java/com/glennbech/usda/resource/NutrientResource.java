package com.glennbech.usda.resource;


import com.glennbech.usda.model.NutrientDefinition;
import com.glennbech.usda.model.SearchResult;
import com.glennbech.usda.model.TopNutrientResponse;
import org.springframework.jdbc.core.RowMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.glennbech.usda.Constants.DEFAULT_PAGE_SIZE;
import static com.glennbech.usda.Constants.MAX_PAGE_SIZE;

/**
 *
 */

@Path("/nutrient")
public class NutrientResource extends BaseResource {

    @GET
    @Produces("application/json")
    public Response getNutrients() throws IOException {

        Response response;
        List<NutrientDefinition> items = getJdbcTemplate().query("SELECT NUTR_NO, UNITS, TAGNAME, NUTR_DESC, SR_ORDER FROM NUTR_DEF", new RowMapper<NutrientDefinition>() {
            @Override
            public NutrientDefinition mapRow(ResultSet resultSet, int i) throws SQLException {

                NutrientDefinition def = new NutrientDefinition() ;
                def.setNutrientDescription(resultSet.getString("NUTR_DESC"));
                def.setNutrientNumber(resultSet.getString("Nutr_No"));
                def.setStandardReferenceOrder(resultSet.getInt("SR_Order"));
                def.setTagName(resultSet.getString("Tagname"));
                def.setUnits(resultSet.getString("Units"));
                return def;
            }
        });
        return Response.ok().entity(items).build();
    }

    @GET
    @Path("/top/{nutrient_no}")
    @Produces("application/json")
    public Response getTopFoodsBuyNutrient(@PathParam("nutrient_no") final String nutrientNumber, @QueryParam("page") Integer page, @QueryParam("pageSize") Integer pagesize) throws IOException {

        Response response;

        pagesize = (pagesize == null) ? DEFAULT_PAGE_SIZE : pagesize;
        page = (page == null) ? 0 : page;

        if (pagesize > MAX_PAGE_SIZE) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please use a pagesize of 50 or below").build();
        }

        int count =  getJdbcTemplate().queryForInt("select count(*) from food_des, nutr_def, nut_data where nutr_def.nutr_no = nut_data.nutr_no and nut_data.ndb_no = food_des.ndb_no and nut_data.nutr_no = ? order by nutr_val desc", new Object[] {nutrientNumber});
        List<TopNutrientResponse> items = getJdbcTemplate().query("select food_des.ndb_no, long_desc, nutr_val from food_des, nutr_def, nut_data where nutr_def.nutr_no = nut_data.nutr_no and nut_data.ndb_no = food_des.ndb_no and nut_data.nutr_no = ? order by nutr_val desc limit ?,?", new Object[]{nutrientNumber, page * pagesize, pagesize}, new RowMapper<TopNutrientResponse>() {
            @Override
            public TopNutrientResponse mapRow(ResultSet resultSet, int i) throws SQLException {
                  TopNutrientResponse top = new TopNutrientResponse();
                top.setLongDescription(resultSet.getString("LONG_DESC"));
                top.setNdbNo(resultSet.getString("NDB_NO"));
                top.setValue(resultSet.getFloat("NUTR_VAL"));
                return top;
            }
        });

        SearchResult<TopNutrientResponse> resultset = new SearchResult<TopNutrientResponse>();
        resultset.setResults(items);
        resultset.setTotalResults(count);
        resultset.setCurrentPage(page);
        resultset.setPageSize(pagesize);
        return Response.ok().entity(resultset).build();
    }

}