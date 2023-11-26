package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;
import com.flipkart.bean.Booking;

import java.util.List;

public class BookingService {

    private final BookingDAO bookingDAO = new BookingDAO();
    public boolean checkBookingOverlap(String customerId,String date,String time){
        //return whether the customer has already booked a slot at same timing
        return false;
    }
    public void addBooking(String userId, String scheduleID) {
        bookingDAO.addBooking(userId, scheduleID);
    }

    public List<Booking> getBookingByCustomerId(String customerId){
        return bookingDAO.getBookingByCustomerId(customerId);
    }

    public void cancelBooking(String bookingID) {
        bookingDAO.cancelBookingById(bookingID);
    }
}
