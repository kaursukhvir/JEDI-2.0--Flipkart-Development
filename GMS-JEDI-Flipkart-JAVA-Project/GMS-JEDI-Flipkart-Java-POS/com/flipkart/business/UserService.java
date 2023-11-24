package com.flipkart.business;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.bean.Customer;

import java.util.List;

public class UserService {

    List<Customer> customerList = new CustomerDAO().getCustomerList();

    public boolean isUserValid(String userName, String password, List<Customer> customerList) {
        for (Customer c : customerList) {
            if (c.getUserName().equals(userName) && c.getPassword().equals(password)) return true;
        }
        return false;
    }

    public boolean login(String userName, String password) {
        if (isUserValid(userName, password, customerList)) {
            System.out.println("Successfully logged in");
        }

        else{
            System.out.println("User or password doesn't match");
            return false;
        }
        return true;
    }

    public boolean register() {
        return true;
    }
}
