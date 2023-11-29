package com.flipkart.DAO;

import com.flipkart.bean.Customer;

public interface CustomerInterfaceDAO {

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    public boolean isUserValid(String userName, String password);
    Customer getCustomerById(String userName);
}
