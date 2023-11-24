package com.flipkart.business;

import com.flipkart.DAO.GymCentreDAO;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }



    public Object addGymOwnerDetails() {
        //takes gymOwner object as input
        return new Object();
    }
}
