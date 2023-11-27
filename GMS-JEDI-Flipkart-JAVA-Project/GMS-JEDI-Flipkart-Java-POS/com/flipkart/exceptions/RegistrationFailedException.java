package com.flipkart.exceptions;

public class RegistrationFailedException extends Exception {
    public RegistrationFailedException(String gymOwnerId) {
        super("Failed to register Gym Owner with id: " + gymOwnerId);
    }
}
