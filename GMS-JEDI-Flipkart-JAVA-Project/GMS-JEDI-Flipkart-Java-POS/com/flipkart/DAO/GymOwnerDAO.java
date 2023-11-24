package com.flipkart.DAO;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerDAO {

    private List<GymOwner> gymOwnerList = new ArrayList<>();
    private List<GymOwner> pendingGymOwnerList = new ArrayList<>();



    public GymOwnerDAO() {
        GymOwner owner1 = new GymOwner("Sita", "sita@flipfit.com", "123", Role.GYMOWNER, "123", "378648327");
        GymOwner owner2 = new GymOwner("Geeta", "geeta@flipfit.com", "456", Role.GYMOWNER, "345", "874648327");
        GymOwner owner3 = new GymOwner("Babita", "babita@flipfit.com", "789", Role.GYMOWNER, "567", "926648327");

        gymOwnerList.add(owner1);
        gymOwnerList.add(owner2);
        gymOwnerList.add(owner3);

    }
    public List<GymOwner> getGymOwnerList() {
        return gymOwnerList;
    }

    public void setGymOwnerList(List<GymOwner> gymOwnerList) {
        this.gymOwnerList = gymOwnerList;
    }

    public void addGymOwner(GymOwner gymOwner){
        this.gymOwnerList.add(gymOwner);
    }

    public List<GymOwner> getPendingGymOwnerList() {
        return pendingGymOwnerList;
    }

    public void sendOwnerApprovalRequest(String gymOwnerId){
        for( GymOwner gymOwner : gymOwnerList ){
            if(gymOwner.getUserID().equals(gymOwnerId)){
                pendingGymOwnerList.add(gymOwner);
                break;
            }
        }
    }
    public void setPendingGymOwnerList(List<GymOwner> pendingGymOwnerList) {
        this.pendingGymOwnerList = pendingGymOwnerList;
    }

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        for(GymOwner gymOwner : gymOwnerList) {
            if(gymOwner.getUserID().equals(gymOwnerId)) {
                gymOwner.setApproved(isApproved);
            }
        }
        for(GymOwner gymOwner : pendingGymOwnerList) {
            if(gymOwner.getUserID().equals(gymOwnerId)) {
                pendingGymOwnerList.remove(gymOwner);
            }
        }
    }
}
