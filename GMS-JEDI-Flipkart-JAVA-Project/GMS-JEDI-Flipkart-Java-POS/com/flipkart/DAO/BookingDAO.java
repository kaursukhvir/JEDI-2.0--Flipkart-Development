package com.flipkart.DAO;

import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.flipkart.constant.SQLConstants.*;

public class BookingDAO {

    public BookingDAO() {
    }

    public void  addBooking(String userName, String scheduleID){
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(ADD_BOOKING);
            stmt.setString(1, userName+ scheduleID);
            stmt.setString(2, userName);
            stmt.setString(3, scheduleID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
//
    }
    public void getBookingByCustomerId(String customerId) {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_CUSTOMER_ID);
            stmt.setString(1, customerId);
            ResultSet output = stmt.executeQuery();
            System.out.println("BookingId \t ScheduleID");
            while(output.next()) {
                System.out.printf("%-12s\t", output.getInt("bookingId") );
                System.out.printf("  %-7s\t",output.getString("scheduleID"));
                System.out.println("");
            }
            System.out.println("*********************************************");
        } catch(SQLException sql) {
            sql.printStackTrace();
        } catch(Exception excep) {
            excep.printStackTrace();
        }
    }

    public void cancelBookingById(String bookingID) {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(CANCEL_BOOKING_BY_ID);
            stmt.setString(1, bookingID);
            stmt.executeUpdate();
        } catch(SQLException sql) {
            sql.printStackTrace();
        } catch(Exception excep) {
        excep.printStackTrace();
    }
    }
}
