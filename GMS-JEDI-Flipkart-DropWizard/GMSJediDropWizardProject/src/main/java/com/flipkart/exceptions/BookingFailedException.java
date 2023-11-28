package main.java.com.flipkart.exceptions;

import static main.java.com.flipkart.constant.Constants.RED_COLOR;
import static main.java.com.flipkart.constant.Constants.RESET_COLOR;

public class BookingFailedException extends RuntimeException{
    public BookingFailedException(String message){
        super(RED_COLOR+message+RESET_COLOR);
    }
}
