package main.java.com.flipkart.exceptions;

import static main.java.com.flipkart.constant.Constants.RED_COLOR;
import static main.java.com.flipkart.constant.Constants.RESET_COLOR;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
        super(RED_COLOR+"Wrong username or password!"+RESET_COLOR);
    }
}
