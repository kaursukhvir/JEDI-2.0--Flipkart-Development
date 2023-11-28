package com.flipkart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {

    @GET
    public String adminLogin() {
        return "my admin service";
    }

}