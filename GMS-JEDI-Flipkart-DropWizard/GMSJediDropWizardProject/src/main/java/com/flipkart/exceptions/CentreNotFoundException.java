package main.java.com.flipkart.exceptions;

import static main.java.com.flipkart.constant.Constants.RED_COLOR;
import static main.java.com.flipkart.constant.Constants.RESET_COLOR;

public class CentreNotFoundException extends RuntimeException{
    public CentreNotFoundException(String gymId){
        super(RED_COLOR+"Gym Centre" + gymId + " not found!"+RESET_COLOR);
    }
}
