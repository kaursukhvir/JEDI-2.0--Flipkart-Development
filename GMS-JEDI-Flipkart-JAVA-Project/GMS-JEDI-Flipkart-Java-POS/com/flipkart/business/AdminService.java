package com.flipkart.business;

import com.flipkart.bean.Role;

public class AdminService {


    public Object approveGymCenter(){
        //takes GymCenter Object as input and return boolean
        System.out.println("Approved/Rejected Gym Center: ");
        return new Object();
    }

    public Object approveGymOwner(){
        //takes GymOwner Object as input and return boolean
        System.out.println("Approved/Rejected Gym Owner: ");
        return new Object();
    }

    public Object viewPendingGymCenters(){
        //views all pending requests
        System.out.println("Viewing pending Gym Center Approvals: ");
        return new Object();
    }

    public Object viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");
        return new Object();
    }

    public Object addAdmin(String userName, String email, String password, Role role){
        //takes username and password, verifies role and redirects to admin home
        System.out.println("Successful login for Admin");
        return new Object();
    }
}
