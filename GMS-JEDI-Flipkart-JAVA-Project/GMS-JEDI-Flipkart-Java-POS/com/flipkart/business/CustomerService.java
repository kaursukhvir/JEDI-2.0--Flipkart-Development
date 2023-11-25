package com.flipkart.business;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();
    private GymCentreService gymCentreService = new GymCentreService();

    public List<GymCentre> getAllGymCenterDetailsByLocation(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    public List<Slot> getAvailableSlots(String centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
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

    public Object bookSlot(String SlotId){
        //book a slot if available

        return new Object();
    }

    public Object cancelBookingbyID(){
        //cancel a booking
        System.out.println("cancelled booking successfully");
        return new Object();
    }

    public void registerCustomer(String userId, String userName, String password, String email, String phoneNumber, String cardNumber) {
        customerDAO.registerCustomer(userId, userName,password,email,phoneNumber,cardNumber);
    }
}
