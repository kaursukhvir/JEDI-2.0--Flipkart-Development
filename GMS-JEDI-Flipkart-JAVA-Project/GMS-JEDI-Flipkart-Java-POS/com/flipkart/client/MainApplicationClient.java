package com.flipkart.client;

import com.flipkart.business.CustomerService;

public class MainApplicationClient {

    public static void main(String[] args) {

        AdminClient admin = new AdminClient();
        CustomerClient customer = new CustomerClient();
        GymOwnerClient gymOwner = new GymOwnerClient();

//        ADMIN
        System.out.println("====================ADMIN====================");

        admin.adminMainPage();

        //        CUSTOMER
        System.out.println("====================CUSTOMER====================");
        customer.customerClientMainPage();

//        GYMOWNER
        System.out.println("====================GYMOWNER====================");
        gymOwner.gymOwnerMainPage();


    }
}
