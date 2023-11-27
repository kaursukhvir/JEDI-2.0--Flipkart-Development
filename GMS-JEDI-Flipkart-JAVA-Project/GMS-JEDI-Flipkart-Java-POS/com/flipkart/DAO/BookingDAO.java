package com.flipkart.DAO;

import com.flipkart.bean.Booking;
import com.flipkart.utils.DBConnection;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Booking> getBookingByCustomerId(String customerId) {
        List<Booking> allBookingList = new ArrayList<>();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_CUSTOMER_ID);
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Booking booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

                allBookingList.add(booking);
            }
        } catch(SQLException sql) {
            sql.printStackTrace();
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return allBookingList;
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
