package com.flipkart.DAO;

import com.flipkart.bean.Customer;

import java.util.List;

public interface CustomerInterfaceDAO {

    public void registerCustomer(String userId,String userName, String password, String email, String phoneNumber, String cardNumber);
    public boolean isUserValid(String userName, String password);
}
