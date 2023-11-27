package com.flipkart.DAO;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;
import com.flipkart.utils.DBConnection;
import com.flipkart.utils.UserPlan;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.flipkart.constant.SQLConstants.*;

public class BookingDAO {



    public BookingDAO() {
    }

    ScheduleDAO scheduleDAO  = new ScheduleDAO();
    public void  addBooking(String userName, String scheduleID){
        try {
            System.out.println(userName + scheduleID);
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(ADD_BOOKING);
            stmt.setString(1, userName+scheduleID);
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

    public List<UserPlan> getUserPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        List<Booking> allBookingList = getBookingByCustomerId(customerId);
        for (Booking booking : allBookingList) {
            try {
                Connection conn = DBConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(GET_USERPLAN_BY_CUSTOMER_ID);
                stmt.setString(1, booking.getScheduleID());
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    UserPlan userPlan = new UserPlan(
                            rs.getString("slotId"),
                            rs.getString("centreId"),
                            rs.getTime("time").toLocalTime(),
                            rs.getString("scheduleID"),
                            rs.getDate("date")
                    );

                    allUserPlan.add(userPlan);
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return allUserPlan;
    }

    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime){
        LocalTime endTime = localTime.plusHours(1);

        List<UserPlan> allUserPlan = getUserPlan(customerId);
        for(UserPlan userPlan:allUserPlan){

            if(userPlan.getDate().equals(date)){
                if(localTime.compareTo(userPlan.getTime())<=0  && endTime.compareTo(userPlan.getTime())>=0){
                    return true;
                }
                else if(userPlan.getTime().compareTo(localTime)<=0  && userPlan.getTime().compareTo(endTime)>=0)
                    return true;
            }
        }
        return false;
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

    public Booking getBookingByBookingId(String bookingId){
        Booking booking  = null;
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_BOOKING_ID);
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

            }
        } catch(SQLException sql) {
            sql.printStackTrace();
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return booking;
    }
}
