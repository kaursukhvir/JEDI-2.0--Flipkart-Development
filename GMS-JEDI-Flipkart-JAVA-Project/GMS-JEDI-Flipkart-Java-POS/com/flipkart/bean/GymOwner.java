package com.flipkart.bean;

import java.util.List;

public class GymOwner extends User{
    private String panNumber;
    private List<String> gymCeterIDs;

    public GymOwner(String userName, String panNumber, List<String> gymCeterIDs) {
        super(userName);
        this.panNumber = panNumber;
        this.gymCeterIDs = gymCeterIDs;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public List<String> getGymCeterIDs() {
        return gymCeterIDs;
    }

    public void setGymCeterIDs(List<String> gymCeterIDs) {
        this.gymCeterIDs = gymCeterIDs;
    }



}
