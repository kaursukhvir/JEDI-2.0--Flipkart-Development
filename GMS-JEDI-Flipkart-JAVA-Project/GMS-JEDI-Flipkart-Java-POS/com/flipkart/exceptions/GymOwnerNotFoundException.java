package com.flipkart.exceptions;

public class GymOwnerNotFoundException extends Exception {
    public GymOwnerNotFoundException(String gymOwnerId){
        super("Gym Owner with ID: " + gymOwnerId + " does not exist.");
    }
}
