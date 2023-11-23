package com.flipkart.bean;

import java.util.List;

public class GymOwner extends User {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;

    public GymOwner(String userName, String panNumber, List<String> gymCentreIDs, String cardDetails) {
        super(userName);
        this.panNumber = panNumber;
        this.gymCentreIDs = gymCentreIDs;
        this.cardDetails = cardDetails;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }
}
