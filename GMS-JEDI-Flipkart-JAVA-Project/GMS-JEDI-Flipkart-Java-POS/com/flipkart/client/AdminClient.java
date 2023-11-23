package com.flipkart.client;

import com.flipkart.business.AdminService;

import java.util.Scanner;

import static com.flipkart.client.MainApplicationClient.scanner;

public class AdminClient {

    private static AdminService adminService = new AdminService();

    private void handleGymOwnerApprovalRequests(){
        while(true /*And the list size is not 0*/){
            // print the list with indexes from 1
            System.out.println("(Press 0 to exit)\nChoose the approval request to modify: ");
            int requestGymOwnerId = scanner.nextInt();

            if(requestGymOwnerId == 0) {return;}

            System.out.println("1. Approve the request\n2. Reject the request");
            int choice = scanner.nextInt();

            System.out.println("Admin Approval for a Gym Owner ----------");
            adminService.approveGymOwner(/*  Get the gym owner by index from requestGymOwnerId and approve or reject based on choice  */);
            //modify the list

        }
    }
    private void handleGymCenterApprovalRequests(){
        while(true /*And the list size is not 0*/) {
            // print the list with indexes from 1
            System.out.println("Press 0 to EXIT or Choose the approval request to modify:");
            int requestGymCenterId = scanner.nextInt();
            if (requestGymCenterId == 0) return;

            System.out.println("(1) Approve the request\n(2) Reject the request\n");
            int choice = scanner.nextInt();

            System.out.println("Admin Approval for a Gym Center ----------");
            adminService.approveGymCenter(/*  Get the gym center by index from requestGymCenterId and approve or reject based on choice  */);
            //modify the list
        }
    }

    public void adminMainPage(){
        System.out.println("Welcome to the Admin Interface. Please select a choice: ");
        while(true){
            System.out.println("1. View Pending GymOwner approval requests\n2. View Pending GymCenter's approval requests\n3. Exit Interface");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 1:
                    adminService.viewPendingGymOwners(); //Get listGymOwnerIds
                    handleGymOwnerApprovalRequests();
                    break;

                case 2:
                    adminService.viewPendingGymCenters();//get listGymCenterIds
                    handleGymCenterApprovalRequests();
                    break;

                case 3:
                    return;
            }
        }


    }
}
