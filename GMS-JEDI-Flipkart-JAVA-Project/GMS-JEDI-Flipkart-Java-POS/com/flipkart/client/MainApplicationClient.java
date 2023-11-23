package com.flipkart.client;
import com.flipkart.bean.Role;
import com.flipkart.business.UserService;

import java.util.Scanner;

public class MainApplicationClient {

    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static AdminClient admin = new AdminClient();
    private static CustomerClient customer = new CustomerClient();
    private static GymOwnerClient gymOwner = new GymOwnerClient();



    private static void redirect(Role role){
        switch (role){
            case ADMIN:
                admin.adminMainPage();
                break;
            case GYMOWNER:
                gymOwner.gymOwnerMainPage();
                break;
            case CUSTOMER:
                customer.customerClientMainPage();
                break;

        }
    }

    private static void login(){

        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        if (userService.login()){
//   we will extract the user role and call the respective mainPage right now we don't have DB we use default

            redirect(Role.CUSTOMER);
        }


    }
    
    private static void registration(){

        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your role");
        Role role = Role.valueOf(scanner.next().toUpperCase());

        userService.register();
        redirect(role);

    }
    
    public static void main(String[] args) {

        System.out.println("Login (1) and Registration (2)");
        int choice = scanner.nextInt();

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
