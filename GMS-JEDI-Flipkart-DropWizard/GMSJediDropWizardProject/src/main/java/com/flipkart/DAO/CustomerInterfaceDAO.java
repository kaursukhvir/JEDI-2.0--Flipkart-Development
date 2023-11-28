package main.java.com.flipkart.DAO;

import main.java.com.flipkart.bean.Customer;
import main.java.com.flipkart.exceptions.RegistrationFailedException;
import main.java.com.flipkart.exceptions.UserInvalidException;

public interface CustomerInterfaceDAO {

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegistrationFailedException;
    public boolean isUserValid(String userName, String password) throws UserInvalidException;
    Customer getCustomerById(String userName);
}
