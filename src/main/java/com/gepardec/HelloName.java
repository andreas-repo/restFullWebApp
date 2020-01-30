package com.gepardec;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("service")
public class HelloName {

    @GET
    @Path("helloname/{name}")
    public Response hello(@PathParam("name")String name) {
        return Response.ok("Hello " +name).build();
    }
}
