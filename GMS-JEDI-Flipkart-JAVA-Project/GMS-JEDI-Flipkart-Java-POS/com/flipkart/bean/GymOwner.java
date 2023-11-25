package com.flipkart.bean;

import java.util.List;

public class GymOwner extends User {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;
    private boolean isApproved;

    public GymOwner(String userName, String email, String password, Role role, String panNumber, String cardDetails) {
        super(userName, email, password, role);
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = false;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
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

    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }
}
