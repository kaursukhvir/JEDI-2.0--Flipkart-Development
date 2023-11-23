package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slots;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public List<Object> getAllGymCenterDetails(){
        //takes City (Location) as input and returns List<GymCenter>
        System.out.println("Gym center details successfully sent");
        return new ArrayList<Object>();
    }

    public List<Object> getAvailableSlots(){
        //takes centerID and date for input and returns List<Slot>
        System.out.println("Available slots successfully sent");
        return new ArrayList<Object>();
    }

    public List<Object> getCustomerBookings(){
        //takes userId and returns List<Bookings>
        System.out.println("customer details successfully sent");
        return new ArrayList<Object>();
    }

    public Object getBookingDetailsByID(){
        System.out.println("booking details successfully sent");
        return new Object();
    }

    public Object register(){
        //takes customer Object and returns true and redirects to customer home
        System.out.println("customer registered successfully");
        return new Object();
    }

    public Object login(){
        //takes username and password, verifies role and redirects to customer home
        System.out.println("customer logged in successfully");
        return new Object();
    }

    public Object bookSlot(){
        //book a slot if available
        System.out.println("slot booked successfully");
        return new Object();
    }

    public Object cancelBookingbyID(){
        //cancel a booking
        System.out.println("cancelled booking successfully");
        return new Object();
    }
}
