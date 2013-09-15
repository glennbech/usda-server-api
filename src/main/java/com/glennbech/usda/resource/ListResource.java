package com.glennbech.usda.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 *
 *
 */
public class ListResource {

    @GET
    @Produces("application/json")
    @Path("/")
    public Response getLists() {
        return null;
    }

    @POST
    @Produces("application/json")
    @Path("/")
    public Response createList() {
        return null;
    }

    @POST
    @Produces("application/json")
    @Path("/{listId}")
    public Response deleteList() {
        return null;
    }


    @GET
    @Produces("application/json")
    @Path("/{listId}")
    public Response getAllItemsInList() {
        return null;
    }

    @POST
    @Produces("application/json")
    @Path("/{listId}")
    public Response addItemToList() {
        return null;
    }

    @DELETE
    @Produces("application/json")
    @Path("/{listId}/{itemid}")
    public Response removeItemFromList() {
        return null;
    }

}