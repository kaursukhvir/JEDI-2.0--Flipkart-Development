package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Role;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    List<Customer> customerList = new ArrayList<Customer>();

    public CustomerDAO() {
        Customer c1 = new Customer("JohnDoe","john.doe@gmail.com","123", Role.CUSTOMER,"1234567890","235675431901");
        Customer c2 = new Customer("JohnSmith","john.smith@gmail.com","456",Role.CUSTOMER,"1234567890","235675431901");
        Customer c3 = new Customer("JoeObama","joe.obama@gmail.com","789",Role.CUSTOMER,"1234567890","235675431901");
        Customer c4 = new Customer("JoeBiden","joe.biden@gmail.com","111",Role.CUSTOMER,"1234567890","235675431901");

        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customerList.add(c4);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
