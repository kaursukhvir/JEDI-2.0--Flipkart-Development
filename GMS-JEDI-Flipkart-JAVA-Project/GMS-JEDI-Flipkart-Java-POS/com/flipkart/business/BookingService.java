package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;

public class BookingService {

    private final BookingDAO bookingDAO = new BookingDAO();
    public boolean checkBookingOverlap(String customerId,String date,String time){
        //return whether the customer has already booked a slot at same timing
        return false;
    }

    public void addBooking() {
        bookingDAO.addBooking();
    }
}
