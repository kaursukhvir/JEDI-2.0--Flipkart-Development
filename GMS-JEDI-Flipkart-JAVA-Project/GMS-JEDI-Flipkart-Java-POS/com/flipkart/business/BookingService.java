package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;
import com.flipkart.DAO.BookingInterfaceDAO;
import com.flipkart.bean.Booking;

import java.util.List;


public class BookingService implements BookingServiceInterface {

    private BookingInterfaceDAO bookingDAO = new BookingDAO();
    public boolean checkBookingOverlap(String customerId,String date,String time){
        //return whether the customer has already booked a slot at same timing
        return false;
    }
    public void addBooking(String userName, String scheduleID) {
        bookingDAO.addBooking(userName, scheduleID);
    }

    public List<Booking> getBookingByCustomerId(String customerId){
        return bookingDAO.getBookingByCustomerId(customerId);
    }

    public void cancelBooking(String bookingID) {
        bookingDAO.cancelBookingById(bookingID);
    }
}
