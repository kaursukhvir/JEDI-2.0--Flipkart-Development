package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.util.Date;
import java.util.List;

public interface CustomerServiceInterface {
    List<GymCentre> getAllGymCenterDetailsByCity(String city);
    List<Slot> getAvailableSlots(String centreID, Date date);
    void getCustomerBookings(String customerId);
    void bookSlot(String userID,Date date, String slotId);
    void cancelBookingbyID(String bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    Customer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);
}
