package com.flipkart.rest;

import com.flipkart.business.CustomerService;
import com.flipkart.client.CustomerClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    CustomerService customerService = new CustomerService();
    @GET
    @Path("/{userName}/{password}")
    public String customerLogin(@PathParam("userName") String userName, @PathParam("password") String password) {

        if(customerService.isUserValid(userName, password)){
            return "Login Successful";
        }
        else{
            return "Login Failed "+userName+password;
        }
    }

}