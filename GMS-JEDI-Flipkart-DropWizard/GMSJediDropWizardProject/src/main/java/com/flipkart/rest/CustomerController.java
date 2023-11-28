package com.flipkart.rest;

import com.flipkart.business.CustomerService;

import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    CustomerServiceInterface customerService = new CustomerService();

    //Customer login
    @GET
    @Path("/{userName}/{password}")
    public Response customerLogin(@PathParam("userName") String userName, @PathParam("password") String password) {
        try{
            if (customerService.isUserValid(userName, password)) {
                System.out.println("Login Successful");
                return getCustomerProfile(userName);
            } else {
                System.out.println("Login Failed for " + userName);
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }catch (Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }

    }

    //View profile
    @GET
    @Path("/viewprofile/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerProfile(@PathParam("userName") String userName){
        Customer customerProfile = customerService.viewMyProfile(userName);
        try{
            return Response.ok(customerProfile).build();
        }catch (Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

}