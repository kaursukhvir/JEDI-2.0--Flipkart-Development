package com.flipkart.client;

import com.flipkart.business.AdminService;

public class AdminClient {
    public void adminMainPage(){

        AdminService adminService = new AdminService();

        System.out.println("Admin logging in -------");
        adminService.login();

        System.out.println("View Pending GymOwner approval requests --------");
        adminService.approveGymOwner();

        System.out.println("Admin Approval for a Gym Owner ----------");
        adminService.approveGymOwner();

        System.out.println("View Pending GymCenter approval requests --------");
        adminService.viewPendingGymOwners();

        System.out.println("Admin Approval for a Gym Center ----------");
        adminService.approveGymCenter();

    }
}
