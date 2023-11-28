package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.business.GymCentreService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.exceptions.DataEntryException;
import com.flipkart.validators.Validators;
import jdk.nashorn.internal.parser.JSONParser;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import static com.flipkart.client.MainApplicationClient.scanner;

@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerController {

    GymOwnerService gymOwnerService = new GymOwnerService();
    GymCentreService gymCentreService  = new GymCentreService();


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCentresByOwnerId() {
        return Response.ok(gymOwnerService.viewAllGymOwners()).build();
    }

    @Path("/gymCentres/{gymOwnerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCentresByOwnerId(@PathParam("gymOwnerId") String gymOwnerId) {
        GymCentreService gymCentreService = new GymCentreService();
        return Response.ok(gymCentreService.getAllCentresByOwmerId(gymOwnerId)).build();
    }

    @GET
    @Path("login/{userName}/{password}")
    public Response GymOwnerLogin(@PathParam("userName") String userName, @PathParam("password") String password) {
        GymOwner gymOwner = gymOwnerService.loginGymOwner(userName, password);
        if(gymOwner==null)
            return Response.notModified().build();
        return Response.ok(gymOwner).build();
    }
    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response GymOwnerRegister(GymOwner gymOwner) {
        GymOwner registerdGymOwner =  gymOwnerService.registerGymOwner(gymOwner);
        if(registerdGymOwner==null)
            return Response.notModified().build();
        return Response.ok(registerdGymOwner).build();
    }
    @POST
    @Path("addCentre/{gymOwnerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGymCentre(@PathParam("gymOwnerId") String gymOwnerId, GymCentre gymCentre) {
        gymCentre.setOwnerID(gymOwnerId);
        System.out.println(gymOwnerId);
        System.out.println(gymCentre);
        GymCentre newGymCentre = gymCentreService.addCenter(gymCentre);
        if(newGymCentre==null)
            return Response.notModified().build();
        return Response.ok(newGymCentre).build();
    }

    @Path("/getApprovalOwner/{gymOwnerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymOwnerApproval(@PathParam("gymOwnerId") String gymOwnerId) {
        gymOwnerService.requestGymOwnerApproval(gymOwnerId);
        return Response.ok("Sent approval request to Admin").build();
    }

    @Path("/getApprovalCentre/{gymCentreId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymCentreApproval(@PathParam("gymCentreId") String gymCentreId) {
        gymCentreService.requestGymCentreApproval(gymCentreId);
        return Response.ok("Sent approval request to Admin").build();
    }
    @Path("/getGymCentre/{gymCentreId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymCentreById(@PathParam("gymCentreId") String gymCentreId) {

        return Response.ok(gymCentreService.getGymCentreById(gymCentreId)).build();
    }


    @Path("getAvailableSlots/{centreId}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAvailableSlots(@PathParam("centreId") String centreId,@QueryParam("Date") String strdate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date date;
        Date sqlDate = null;
        try {
            date = sdf.parse(strdate);
            sqlDate = new Date(date.getTime());
        } catch (ParseException e) {
            System.out.println("\n\n\n\n\n\n UNABLE TO PARSE");
        }
        return Response.ok(gymCentreService.getAvailableSlotsByCentreAndDate(centreId,sqlDate)).build();
    }


    @Path("getCentresByCity/{cityName}/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCentreByCity(@PathParam("cityName") String cityName) {

        return Response.ok(gymCentreService.getCentresByCity(cityName)).build();
    }



}
