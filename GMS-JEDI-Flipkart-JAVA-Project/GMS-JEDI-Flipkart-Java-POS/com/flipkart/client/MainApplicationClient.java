package com.flipkart.client;
import com.flipkart.business.UserService;

import java.util.Scanner;

public class MainApplicationClient {

    private static Scanner scan = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static AdminClient admin = new AdminClient();
    private static CustomerClient customer = new CustomerClient();
    private static GymOwnerClient gymOwner = new GymOwnerClient();



    private static void redirect(String role){
        switch (role){
            case "Admin":
                admin.adminMainPage();
                break;
            case "GymOwner":
                gymOwner.gymOwnerMainPage();
                break;
            case "Customer":
                customer.customerClientMainPage();
                break;

        }
    }

    private static void login(){

        System.out.println("Enter your UserName");
        String userName = scan.next();

        System.out.println("Enter your Passkey");
        String password = scan.next();

        if (userService.login()){
//   we will extract the user role and call the respective mainPage right now we don't have DB we use default
            String role = "Customer";
            redirect(role);
        }


    }
    
    private static void registration(){

        System.out.println("Enter your UserName");
        String userName = scan.next();

        System.out.println("Enter your Passkey");
        String password = scan.next();

        System.out.println("Enter your role");
        String role = scan.next();

        userService.register();
        redirect(role);

    }
    
    public static void main(String[] args) {

        System.out.println("Login (1) and Registration (2)");
        int choice = scan.nextInt();

        switch (choice){
            case 1:
                login();
                break;

            case 2:
                registration();
                break;
        }
//
//        //ADMIN
//        System.out.println("====================ADMIN====================");
//
//        admin.adminMainPage();
//
//        //CUSTOMER
//        System.out.println("====================CUSTOMER====================");
//        customer.customerClientMainPage();
//
//        //GYMOWNER
//        System.out.println("====================GYMOWNER====================");
//        gymOwner.gymOwnerMainPage();


    }
}
