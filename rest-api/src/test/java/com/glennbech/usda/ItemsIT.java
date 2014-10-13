package com.glennbech.usda;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.Header;
import com.eclipsesource.restfuse.annotation.HttpTest;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static com.eclipsesource.restfuse.Assert.assertCreated;
import static com.eclipsesource.restfuse.Assert.assertOk;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
@RunWith(HttpJUnitRunner.class)
@Ignore
public class ItemsIT {

    public static final String ENDPOINT_LIST = "/list";
    @Rule
    public Destination restfuseEndPoint = new Destination("http://localhost:8080/api");

    @Context
    private Response response;

    @HttpTest(method = Method.POST, path = ENDPOINT_LIST, headers = {@Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw")})
    public void createAList() throws JSONException {
        assertCreated(response);
        String body = response.getBody(String.class);
        JSONObject responseBody = new JSONObject(body);
        assertNotNull(responseBody.getJSONObject("listName"));
        assertNotNull(responseBody.getJSONObject("listUID"));
    }

    @HttpTest(method = Method.DELETE, path = ENDPOINT_LIST, headers = {@Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw")})
    public void deleteAList() throws JSONException {
        assertOk(response);
    }

    @HttpTest(method = Method.GET, path = ENDPOINT_LIST, headers = {@Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw")})
    public void getAllLists() throws JSONException {


    }

    @HttpTest(method = Method.GET, path = ENDPOINT_LIST, headers = {@Header(name = "X-Mashape-Authorization", value = "ix1apuk2jl00oktejn7spp7v4i6vtw")})
    public void getSimilarFoods() throws JSONException {


    }

}

