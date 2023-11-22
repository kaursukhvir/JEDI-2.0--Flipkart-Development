package com.flipkart.bean;

import java.util.List;

public class GymOwner extends User{
    private int panNumber;


    private String gymOwnerName;
    private List<String> gymCeterIDs;

    public GymOwner(String userName, int panNumber, String gymOwnerName, List<String> gymCeterIDs) {
        super(userName);
        this.panNumber = panNumber;
        this.gymOwnerName = gymOwnerName;
        this.gymCeterIDs = gymCeterIDs;
    }

    public int getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(int panNumber) {
        this.panNumber = panNumber;
    }

    public String getGymOwnerName() {
        return gymOwnerName;
    }

    public void setGymOwnerName(String gymOwnerName) {
        this.gymOwnerName = gymOwnerName;
    }

    public List<String> getGymCeterIDs() {
        return gymCeterIDs;
    }

    public void setGymCeterIDs(List<String> gymCeterIDs) {
        this.gymCeterIDs = gymCeterIDs;
    }



}
