package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;
public class AdminDAO implements AdminInterfaceDAO {

    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private static GymCentreDAO gymCentreDAO = new GymCentreDAO();


    public List<GymOwner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        gymOwnerDAO.validateGymOwner(gymCentreId, isApproved);
    }

    public List<GymCentre> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }




}
