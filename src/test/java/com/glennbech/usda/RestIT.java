package com.glennbech.usda;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.Header;
import com.eclipsesource.restfuse.annotation.HttpTest;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static com.eclipsesource.restfuse.Assert.assertOk;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 *
 */
@RunWith(HttpJUnitRunner.class)
public class RestIT {

    @Rule
    public Destination restfuse = new Destination("http://localhost:8080/api");

    @Context
    private Response response;

    @HttpTest(method = Method.GET, path = "/foodgroup", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkFoodGroupsOk() throws JSONException {
        assertOk(response);
        String body = response.getBody(String.class);
        JSONArray jsonArray = new JSONArray(body);
        assertTrue(jsonArray.length() == 25);
    }


    @HttpTest(method = Method.GET, path = "/fooditem/01001", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkfoodItem() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        assertNotNull(o.get("longDescription"));
    }

    @HttpTest(method = Method.GET, path = "/fooditem/search/apple", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void searchForApple() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        assertEquals(o.getInt("pageSize"), 10);
        assertEquals(o.getInt("currentPage"), 0);
        assertEquals(o.getInt("totalResults"), 83);
    }

    @HttpTest(method = Method.GET, path = "/fooditem/search/apple?pageSize=50", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void searchForAppleWithPageSize() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        assertEquals(o.getInt("pageSize"), 50);
        assertEquals(o.getInt("currentPage"), 0);
        assertEquals(o.getInt("totalResults"), 83);
    }

    private JSONObject assertOkAndGetJsonObjectFromBody() throws JSONException {
        assertOk(response);
        String body = response.getBody(String.class);
        return new JSONObject(body);
    }


    @HttpTest(method = Method.GET, path = "/fooditem/01001?nutrients=true", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkfoodItemWithNutrients() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        JSONArray a = o.getJSONArray("nutrients");
        assertTrue(a.length() != 0);
    }


    @HttpTest(method = Method.GET, path = "/fooditem/01001?nutrients=true&weight=true", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkfoodItemWithNutrientsAndWeights() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();

        JSONArray a = o.getJSONArray("nutrients");
        assertTrue(a.length() != 0);

        a = o.getJSONArray("weight");
        assertTrue(a.length() != 0);

    }


    @HttpTest(method = Method.GET, path = "/nutrient", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkNutrients() throws JSONException {
        assertOk(response);

        String body = response.getBody(String.class);
        JSONArray o = new JSONArray(body);

        assertTrue(o.length() != 0);
    }

    @HttpTest(method = Method.GET, path = "/nutrient/top/0203", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void checkNutrientsTopList() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        assertTrue(o.length() != 0);
    }

    @HttpTest(method = Method.GET, path = "/foodgroup/0200", headers = { @Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw") })
    public void getFoodGroupDetails() throws JSONException {
        JSONObject o = assertOkAndGetJsonObjectFromBody();
        JSONArray a = o .getJSONArray("results");

        System.out.println("----------------------->>>>> " + a.length());
        assertTrue(a.length() == 10);
    }


    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
