package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerService {
    public GymOwner register(){
        //takes gymowner Object and returns true and redirects to gymowner home
        System.out.println("Gym Owner successfully registered");
        return new GymOwner("John Doe", "1234", new ArrayList<>(),"1234");
    }

    public Object login(){
        //takes username and password, verifies role and redirects to gymowner home
        System.out.println("Gym Owner successfully logged in");
        return new Object();
    }

    public void requestGymOwnerApproval() {
        System.out.println("Successfully Sent Gym Owner Approval Request to Admin");
    }

    public Object addCenter() {
        //takes gymCenter details
        System.out.println("Successfully added Center Details");
        return new Object();
    }







    public Object addGymOwnerDetails() {
        //takes gymOwner object as input
        return new Object();
    }
}
