package com.flipkart.business;

import com.flipkart.bean.GymCentre;

import java.util.ArrayList;

public class GymCentreService {

    public ArrayList<String> getCentresByCity(String city){
        //return the list of centres in a particular city
        return new ArrayList<String>();
    }

    public void requestCentreApproval(){
        // sends request to Admin for approval of a new centre
        System.out.println("Successfully Sent Gym Centre Approval Request to Admin");
    }
}
