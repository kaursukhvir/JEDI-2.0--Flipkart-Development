package com.flipkart.bean;

import java.util.List;

public class GymCentre {

    private String gymCentreID;
    private String gymCenterName;
    private String ownerID;
    private String city;
    private int capacity;
    private boolean isApproved;
    public GymCentre() {}

    @Override
    public String toString() {
        return "GymCentre{" +
                "gymCentreID='" + gymCentreID + '\'' +
                ", gymCenterName='" + gymCenterName + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public GymCentre(String gymCentreID, String gymCenterName, String ownerID, String city, int capacity) {
        this.gymCentreID = gymCentreID;
        this.gymCenterName = gymCenterName;
        this.ownerID = ownerID;
        this.city = city;
        this.capacity = capacity;
        this.isApproved = false;
    }

    public String getGymCentreID() {
        return gymCentreID;
    }

    public void setGymCentreID(String gymCentreID) {
        this.gymCentreID = gymCentreID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGymCenterName() {
        return gymCenterName;
    }

    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
