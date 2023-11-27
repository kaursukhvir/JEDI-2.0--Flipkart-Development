package com.flipkart.exceptions;

public class BookingFailedException extends RuntimeException{
    public BookingFailedException(String message){
        super(message);
    }
}
