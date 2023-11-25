package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerInterfaceDAO {

    public void registerCustomer(String userId,String userName, String password, String email, String phoneNumber, String cardNumber) {
        Customer customer = new Customer(userId,userName, password,email,phoneNumber, cardNumber);
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customer values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, customer.getCardDetails());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getUserID());
            stmt.setString(4, customer.getUserName());
            stmt.setString(5, customer.getPassword());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException var3) {
            var3.printStackTrace();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        System.out.println("Added Customer details");
    }


    public boolean isUserValid(String userName, String password) {
        return true;
    }
}
