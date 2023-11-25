package com.flipkart.business;

import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;

public class GymOwnerService {
    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }



    public Object addGymOwnerDetails() {
        //takes gymOwner object as input
        return new Object();
    }

    public void registerGymOwner(String userName, String password, String email, String panNumber,String cardNumber) {
        gymOwnerDAO.registerGymOwner(new GymOwner(userName,password, email,Role.GYMOWNER,panNumber,cardNumber));
    }
}
