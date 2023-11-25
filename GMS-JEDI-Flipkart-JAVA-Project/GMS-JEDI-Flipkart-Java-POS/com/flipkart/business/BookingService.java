package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;

public class BookingService {

    private final BookingDAO bookingDAO = new BookingDAO();
    public boolean checkBookingOverlap(String customerId,String date,String time){
        //return whether the customer has already booked a slot at same timing
        return false;
    }
    public void addBooking(String userId, String scheduleID) {
        bookingDAO.addBooking(userId, scheduleID);
    }

    public void getBookingByCustomerId(String customerId){
        bookingDAO.getBookingByCustomerId(customerId);
    }

    public void cancelBooking(String bookingID) {
        bookingDAO.cancelBookingById(bookingID);
    }
}
