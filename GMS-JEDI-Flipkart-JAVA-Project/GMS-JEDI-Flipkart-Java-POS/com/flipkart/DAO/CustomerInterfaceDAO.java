package com.flipkart.DAO;

import com.flipkart.bean.Customer;

import java.util.List;

public interface CustomerInterfaceDAO {
    public List<Customer> getCustomerList();
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
}
