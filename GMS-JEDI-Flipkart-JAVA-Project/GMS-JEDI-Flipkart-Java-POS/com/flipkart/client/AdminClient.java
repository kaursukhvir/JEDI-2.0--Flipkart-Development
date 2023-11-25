package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminService;
import com.flipkart.business.GymOwnerService;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class AdminClient {

    private static Admin admin = new Admin();
    private static AdminService adminService = new AdminService();
    private static GymOwnerService gymOwnerService = new GymOwnerService();

    public boolean isUserValid(String userName, String password) {
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean adminLogin(String userName, String password) {
        if (isUserValid(userName, password)) {
            System.out.println("Successfully logged in");
            adminClientMainPage();
        }
        else{
            System.out.println("UserName or password doesn't match");
            return false;
        }
        return true;
    }

    private void handleGymOwnerApprovalRequests(){
            // print the list with indexes from 1
            System.out.println("Admin Approval for a Gym Owner ----------");

            System.out.println("(Press 0 to exit)\nEnter the Id of Gym Owner:");
            String requestGymOwnerId = scanner.next();

            if(requestGymOwnerId.equals("0")) {return;}

            System.out.println("1. Approve the request\n2. Reject the request");
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println(APPROVAL_GYM_OWNER_CONFIRMATION);
            } else if (choice == 2) {
                System.out.println(DISAPPROVAL_GYM_OWNER_CONFIRMATION);
            }

            adminService.approveGymOwner(requestGymOwnerId,choice == 1);
            //modify the list
            adminClientMainPage();
    }
    private void handleGymCenterApprovalRequests(){
            // print the list with indexes from 1
            System.out.println("Press 0 to EXIT_MESSAGE or Choose The Request To Modify:");
            String requestGymCenterId = scanner.next();
            if (requestGymCenterId.equals("0")) return;
//            Now Admin will select an request and we will pop up with two
            System.out.println("1. Approve the request\n2. Reject the request\n");
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println(APPROVAL_GYM_CENTRE_CONFIRMATION);
            } else if (choice == 2) {
                System.out.println(DISAPPROVAL_GYM_CENTRE_CONFIRMATION);
            }
            adminService.approveGymCenter(requestGymCenterId,choice==1);
            //modify the list
            adminClientMainPage();
    }

    public void adminClientMainPage(){
        System.out.println("Welcome To the Admin Interface. Please select a choice: ");
        while(true){
            System.out.println("0. View All Gym Owners\n1. View Pending GymOwner Approval Requests\n2. View Pending GymCenter's Approval Requests\n3. Go Back To Previous Menu");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
                    List<GymOwner> allGymOwners =  gymOwnerService.viewAllGymOwners();
                    System.out.println("---------------------------------------------------------");
//                    System.out.printf("%-5s\t", "GYM-OWNER-ID");
//                    System.out.printf("%-5s\t", "OWNER-NAME");
//                    System.out.printf("%-5s\t", "EMAIL-ID");
//                    System.out.printf("%-15s\t", "PAN-NUMBER");
//                    System.out.printf("%-8s\t\n", "IS-APPROVED");
                    for(GymOwner gymOwner: allGymOwners) {
                        System.out.printf("%-8s\t", gymOwner.getUserID());
                        System.out.printf("%-8s\t", gymOwner.getUserName());
                        System.out.printf("%-8s\t", gymOwner.getEmail());
                        System.out.printf("%-8s\t", gymOwner.getPanNumber());
                        if(gymOwner.isApproved())
                        {
                            System.out.println("Yes\n");
                        }
                        else
                        {
                            System.out.println("No\n");
                        }
                        System.out.println("");
                    }
                    System.out.println("---------------------------------------------------------");
                    break;
                case 1:
                    List<GymOwner> pendingGymOwners = adminService.viewPendingGymOwners(); //Get listGymOwnerIds
                    System.out.println("---------------------------------------------------------");
//                    System.out.printf("%-5s\t", "GYM-OWNER-ID");
//                    System.out.printf("%-5s\t", "OWNER-NAME");
//                    System.out.printf("%-5s\t", "EMAIL-ID");
//                    System.out.printf("%-15s\t", "PAN-NUMBER");
//                    System.out.printf("%-8s\t\n", "IS-APPROVED");
                    for(GymOwner gymOwner: pendingGymOwners) {
                        System.out.printf("%-8s\t", gymOwner.getUserID());
                        System.out.printf("%-8s\t", gymOwner.getUserName());
                        System.out.printf("%-8s\t", gymOwner.getEmail());
                        System.out.printf("%-8s\t", gymOwner.getPanNumber());
                        if(gymOwner.isApproved())
                        {
                            System.out.println("Yes\n");
                        }
                        else
                        {
                            System.out.println("No\n");
                        }
                        System.out.println("");
                    }
                    System.out.println("---------------------------------------------------------");
//                    handleGymOwnerApprovalRequests();
                    break;

                case 2:
                    List<GymCentre> pendingGymCentres = adminService.viewPendingGymCentres();//get listGymCenterIds
                    System.out.println("---------------------------------------------------------");
//                    System.out.printf("%-5s\t", "GYM-OWNER-ID");
//                    System.out.printf("%-5s\t", "OWNER-NAME");
//                    System.out.printf("%-5s\t", "EMAIL-ID");
//                    System.out.printf("%-15s\t", "PAN-NUMBER");
//                    System.out.printf("%-8s\t\n", "IS-APPROVED");
                    for(GymCentre gymCentre: pendingGymCentres) {
                        System.out.printf("%-8s\t", gymCentre.getGymCentreID());
                        System.out.printf("%-8s\t", gymCentre.getCity());
                        System.out.printf("%-8s\t", gymCentre.getOwnerID());
                        System.out.printf("%-8s\t", gymCentre.getCapacity());
                        if(gymCentre.isApproved())
                        {
                            System.out.println("Yes\n");
                        }
                        else
                        {
                            System.out.println("No\n");
                        }
                        System.out.println("");
                    }
                    System.out.println("---------------------------------------------------------");
                    handleGymCenterApprovalRequests();
                    break;

                case 3:
                    return;
            }
        }


    }

}
