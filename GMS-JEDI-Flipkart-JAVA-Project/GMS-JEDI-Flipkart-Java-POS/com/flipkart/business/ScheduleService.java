package com.flipkart.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkart.DAO.ScheduleDAO;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

public class ScheduleService {

    private GymCentreService gymCentreService = new GymCentreService();
    private SlotService slotService = new SlotService();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    public void createSchedule(){
        //creates a new schedule
    }

    public Schedule getScheduleDetails(String scheduleId){
        //give the schedule details of given date and slot
        return new Schedule("123",new Date(2023, 12, 11),"345",15);
    }

    public boolean isSchedule(){
        //returns whether current schedule exists or not
        return true;
    }

    public void modifySchedule(String scheduleId,int action){
        // increment or decrement availability based on action
    }

    public boolean checkAvailability(String centreID, Date date){
        return  true;
    }

    public List<Slot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<Slot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<Slot> response = slotService.getAllSlotsByCentre(centreID);
        for(Slot slot: allSlotsOfThatCentre){
            for(Schedule schedule: scheduleDAO.getAllScheduleByDate(date)){
                if (slotService.getSlotByID(schedule.getSlotID()).getCentreID().equals(centreID)){
                    if(schedule.getAvailability() <= 0){
                        response.remove(slot);
                    }
                }
            }
        }
        return response;
    }
}
