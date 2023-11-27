package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<Booking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
}
