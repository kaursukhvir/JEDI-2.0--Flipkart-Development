package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.business.CustomerService;

import java.util.List;

public class CustomerClient {

    public static void main(String[] args) {

        CustomerService customerService  =  new CustomerService();

        Customer customer   = (Customer) customerService.register();

        System.out.println("Get Gym Details");
        List<GymCentre> ListgymCentre = (List<GymCentre>) customerService.getAllGymCenterDetails();

        System.out.println("Get All available slots");
        List<Slot> Slot = (List<GymCentre>) customerService.getAllGymCenterDetails();


        customerService.getAllGymCenterDetails();
    }

}
