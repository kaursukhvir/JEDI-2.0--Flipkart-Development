package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;
import com.flipkart.DAO.ScheduleDAO;
import com.flipkart.bean.Booking;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;
import com.flipkart.utils.UserPlan;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import java.util.UUID;

public class BookingService implements BookingServiceInterface {

    private final BookingDAO bookingDAO = new BookingDAO();
    private final ScheduleService scheduleService  = new ScheduleService();

    private final SlotService slotService = new SlotService();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        //return whether the customer has already booked a slot at same timing
        Slot slot = slotService.getSlotByID(slotId);
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }
    public void addBooking(String userName, String scheduleID) {
        bookingDAO.addBooking(userName, scheduleID);
        scheduleService.modifySchedule(scheduleID,-1);
    }

    public List<Booking> getBookingByCustomerId(String customerId){
        return bookingDAO.getBookingByCustomerId(customerId);
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    public void cancelBooking(String bookingID) {

        Booking booking  = bookingDAO.getBookingByBookingId(bookingID);
        bookingDAO.cancelBookingById(bookingID);
        scheduleService.modifySchedule(booking.getScheduleID(),1);
    }
}
