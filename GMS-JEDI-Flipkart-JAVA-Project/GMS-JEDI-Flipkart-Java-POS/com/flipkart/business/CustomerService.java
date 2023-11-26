package com.flipkart.business;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();
    private GymCentreService gymCentreService = new GymCentreService();
    private BookingService bookingService = new BookingService();
    private ScheduleService scheduleService = new ScheduleService();

    public List<GymCentre> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    public List<Slot> getAvailableSlots(String centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    public List<Booking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }

    public Object getBookingDetailsByID(){
        System.out.println("booking details successfully sent");
        return new Object();
    }

    public void bookSlot(String userName,Date date, String slotId){
        //check if booking is overlapping
        checkOverlap();
        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        //create booking
        bookingService.addBooking(userName, scheduleId);
        return;
    }

    private void checkOverlap() {
    }

    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        customerDAO.registerCustomer(userName,password,email,phoneNumber,cardNumber);
    }

    public Customer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        return customerDAO.isUserValid(userName,password);
    }
}
