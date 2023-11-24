package com.flipkart.client;
import com.flipkart.bean.Role;
import com.flipkart.business.UserService;

import java.util.Scanner;

import static com.flipkart.constant.Constants.*;

public class MainApplicationClient {

    public static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static AdminClient adminClient = new AdminClient();
    private static CustomerClient customerClient = new CustomerClient();
    private static GymOwnerClient gymOwnerClient = new GymOwnerClient();


    private static void mainPage(){
        while(true) {
            System.out.println("1. Login\n2. Registration\n3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registration();
                    break;
                case 3:
                    System.out.println(EXIT_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }

        }
    }

//    private static void redirect(Role role){
//        switch (role){
//            case ADMIN:
//                admin.adminMainPage();
//                break;
//            case GYMOWNER:
//                gymOwner.gymOwnerMainPage();
//                break;
//            case CUSTOMER:
//                customer.customerClientMainPage();
//                break;
//
//        }
//    }

    private static void login(){

        System.out.println("Enter your Role");
        Role role = Role.valueOf(scanner.next().toUpperCase());

        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

            switch (role){
                case ADMIN:
                    adminClient.adminLogin(userName,password);
                    break;
                case GYMOWNER:
                    gymOwnerClient.gymOwnerLogin(userName,password);
                    break;
                case CUSTOMER:
                    customerClient.customerLogin(userName,password);
                    break;

            }


    }
    
    private static void registration(){

        System.out.println("Enter your role");
        Role role = Role.valueOf(scanner.next().toUpperCase());

        switch (role){
            case ADMIN:
                System.out.println("Admin is already registered");
                mainPage();
                break;
            case CUSTOMER:
                customerClient.register();
                break;
            case GYMOWNER:
                gymOwnerClient.register();
                break;
            default:
                System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        mainPage();
    }
}
