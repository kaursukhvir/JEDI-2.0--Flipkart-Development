package main.java.com.flipkart.business;

import main.java.com.flipkart.bean.Booking;
import main.java.com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public interface BookingServiceInterface {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<Booking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
    List<UserPlan> getCustomerPlan(String customerId);
}
