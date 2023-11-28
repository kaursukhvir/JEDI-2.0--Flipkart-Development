package main.java.com.flipkart.business;

import main.java.com.flipkart.bean.Booking;
import main.java.com.flipkart.bean.Customer;
import main.java.com.flipkart.bean.GymCentre;
import main.java.com.flipkart.bean.Slot;
import main.java.com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.util.List;

public interface CustomerServiceInterface {
    List<GymCentre> getAllGymCenterDetailsByCity(String city);
    List<Slot> getAvailableSlots(String centreID, Date date);
    List<Booking> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBookingbyID(String bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    Customer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);

    List<UserPlan> getCustomerPlan(String userName);
}
