package com.flipkart.business;

import com.flipkart.DAO.GymCentreDAO;
import com.flipkart.bean.GymCentre;

import java.util.ArrayList;

public class GymCentreService {

    private static GymCentreDAO gymCentreDAO = new GymCentreDAO();
    public ArrayList<String> getCentresByCity(String city){
        //return the list of centres in a particular city
        return new ArrayList<String>();
    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        gymCentreDAO.addGymCentre(gymCentre);

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

}
