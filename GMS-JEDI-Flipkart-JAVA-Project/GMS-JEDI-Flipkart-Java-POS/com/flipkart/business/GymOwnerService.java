package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;

import java.util.List;

public class GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    public List<GymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }


    public Object addGymOwnerDetails() {
        //takes gymOwner object as input
        return new Object();
    }

    public void loginGymOwner(String username,String password){
        gymOwnerDAO.loginGymOwner(username,password);
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        gymOwnerDAO.registerGymOwner(new GymOwner(userId,userName,password, email,Role.GYMOWNER,panNumber,cardNumber));
    }
}
