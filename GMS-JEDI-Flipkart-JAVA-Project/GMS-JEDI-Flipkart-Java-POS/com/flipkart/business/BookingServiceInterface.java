package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(String customerId,String date,String time);
    void addBooking(String userId, String scheduleID);
    List<Booking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
}
