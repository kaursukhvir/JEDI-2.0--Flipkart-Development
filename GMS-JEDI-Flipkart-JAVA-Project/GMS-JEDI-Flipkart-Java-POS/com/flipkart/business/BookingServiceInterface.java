package com.flipkart.business;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(String customerId,String date,String time);
    void addBooking(String userId, String scheduleID);
    void getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
}
