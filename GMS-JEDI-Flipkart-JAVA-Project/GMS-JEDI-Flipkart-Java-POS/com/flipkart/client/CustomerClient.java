package com.flipkart.client;

import com.flipkart.business.CustomerService;

import java.util.List;

public class CustomerClient {

    public static void main(String[] args) {

        CustomerService customerService  =  new CustomerService();

        customerService.register();

        System.out.println("Get List of Gym Centres for a location -------");
        List<Object> gymCentreList = customerService.getAllGymCenterDetails();

        System.out.println("Get All available slots -------");
        List<Object> slotList = customerService.getAvailableSlots();

        System.out.println("Get User Bookings Details -------");
        List<Object> bookingList = customerService.getCustomerBookings();

        System.out.println("Get Specific booking details -------");
        customerService.getBookingDetailsByID();

        System.out.println("Book a Slot -------");
        customerService.bookSlot();

        System.out.println("Cancel Booking -------");
        customerService.cancelBookingbyID();

        System.out.println("Get Centre Details -------");
        customerService.getAllGymCenterDetails();
    }

}
