package main.java.com.flipkart.business;

import main.java.com.flipkart.bean.GymCentre;
import main.java.com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminServiceInterface {
    public void approveGymCenter(String gymCentreId,int isApproved);
    void approveGymOwner(String gymOwnerId,int isApprove);
    List<GymCentre> viewPendingGymCentres();
    List<GymOwner> viewPendingGymOwners();
}
