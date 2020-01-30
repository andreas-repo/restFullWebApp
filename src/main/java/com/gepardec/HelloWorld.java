package com.gepardec;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

//the class path
@Path("tutorial")
public class HelloWorld {

    //returns the hello world phrase
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/helloworld
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("helloworld") //the method path
    public Response helloworld() {
        return Response.ok("Hello World!").build();
    }

    //returns the to the URL appended name
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/helloname/<name>
    @GET
    @Path("helloname/{name}")   //method path and {name}-parameter
    public Response hello(@PathParam("name") String name) {
        return Response.ok("Hello " +name).build();
    }

    //returns one item
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/item
    @GET
    @Path("item")   //method path
    @Produces({"application/xml"})
    public Item getItem() {
        Item item = new Item("computer", 2500);

        return item;
    }

    //If you need to return an array of Item objects, you can simply use:
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/itemArray
    @GET
    @Path("itemArray")  //method path
    @Produces({"application/xml"})
    public Item[] getItemArray() {
        Item[] item = new Item[2];
        item[0] = new Item("computer", 2500);
        item[1] = new Item("chair", 100);

        return item;
    }

    //use standard Java collections with a wrapper
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/itemList
    @GET
    @Path("itemList")   //method path
    @Produces({"application/xml"})
    public ItemList getCollectionItems() {
        ArrayList list = new ArrayList();
        Item item1 = new Item("computer", 2500);
        Item item2 = new Item("chair", 100);
        Item item3 = new Item("table", 200);

        list.add(item1);
        list.add(item2);
        list.add(item3);

        return new ItemList(list);
    }

    //sends the ItemList as a JSON
    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/items
    @GET
    @Path("items")
    @Produces("application/json")
    public ItemList getJSONItems() {
        ArrayList list = new ArrayList();
        Item item1 = new Item("computer", 2500);
        Item item2 = new Item("chair", 100);
        Item item3 = new Item("table", 200);

        list.add(item1);
        list.add(item2);
        list.add(item3);

        return new ItemList(list);
    }

    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/2019/11/8
    @GET
    @Path("{year}/{month}/{day}")
    public Response getDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
        String date = year + "/" + month + "/" + day;

        return Response.status(200).entity("getDate is called, year/month/day : " +date).build();
    }

    //http://localhost:8080/restFullWebApp_war_exploded/rest/tutorial/message/yoo
    @GET
    @Path("/message/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "JBoss says: " +msg;

        return Response.status(200).entity(output).build();
    }




}