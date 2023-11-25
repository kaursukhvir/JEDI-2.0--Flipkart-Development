package com.flipkart.DAO;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerInterfaceDAO {
    List<Customer> customerList = new ArrayList<Customer>();

    public CustomerDAO() {
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void registerCustomer(String userId, String userName, String password, String email, String phoneNumber, String cardNumber){
        Customer customer = new Customer(userId, userName,email,password, phoneNumber,cardNumber);
        customerList.add(customer);
        System.out.println("Registered Successfully");
        return;
    }
}
