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

    public Schedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCentreID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        return new Schedule(String.valueOf(date)+slotId, date, slotId,availability);
    }

    public Schedule getScheduleByDateandSlotId(String SlotId, Date date){
        //returns whether current schedule exists or not
        return null;
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

    public Schedule getOrCreateSchedule(String slotId, Date date) {
        if(getScheduleByDateandSlotId(slotId,date) == null ){
            return createSchedule(date,slotId);
        }
        return getScheduleByDateandSlotId(slotId,date);

    }
}
