package com.dropwizard;


import com.flipkart.rest.AdminController;
import com.flipkart.rest.CustomerController;
import com.flipkart.rest.GymOwnerController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.PathParam;

public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        //  e.jersey().register(new EmployeeRESTController(e.getValidator()));

        System.out.println("HERE");
        e.jersey().register(new AdminController());
        e.jersey().register(new CustomerController());
        e.jersey().register(new GymOwnerController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
