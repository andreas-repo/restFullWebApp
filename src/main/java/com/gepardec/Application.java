package com.gepardec;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Application")
public class Application {

    //http://localhost:8080/restFullWebApp_war_exploded/rest/Application/<message>
    @GET
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String message) {
        String output = "JBoss say: " +message;

        return Response.status(200).entity(output).build();
    }

    //http://localhost:8080/restFullWebApp_war_exploded/rest/Application/<year>/<month>/<day>
    @GET
    @Path("{year}/{month}/{day}")
    public Response getDate(
            @PathParam("year") int year,
            @PathParam("month") int month,
            @PathParam("day") int day
    ) {
        String date = year + "/" + month +"/" +day;

        return Response.status(200).entity("getDate is called, year/month/day: " +date).build();
    }

    @POST
    @Path("/add")
    public Response addUser(
            @FormParam("id") int id,
            @FormParam("name") String name,
            @FormParam("price") float price
    ) {
        return Response.status(200).entity(" Product added successfully! <br> ID: " +id +"<br> Name: " +name +"<br> Price: " +price).build();
    }

}
