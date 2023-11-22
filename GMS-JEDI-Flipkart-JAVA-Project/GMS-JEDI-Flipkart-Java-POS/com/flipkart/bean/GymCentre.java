package com.flipkart.bean;

import java.util.List;

public class GymCentre {

    private String gymCentreID;
    private String gymCenterName;
    private String ownerID;
    private String city;
    private int capacity;

    public GymCentre( String gymCenterName, String ownerID, String city, int capacity) {
        this.gymCenterName = gymCenterName;
        this.ownerID = ownerID;
        this.city = city;
        this.capacity = capacity;
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

}
