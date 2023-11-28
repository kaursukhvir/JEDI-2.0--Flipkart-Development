package com.flipkart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerController {

    @GET
    public String gymOwnerLogin() {
        return "my gym owner service";
    }

}