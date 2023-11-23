package com.flipkart.business;

import java.time.*;
import java.util.Date;

import com.flipkart.bean.Schedule;

public class ScheduleService {

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

    public boolean checkAvailability(){
        //check whether there is a seat or not in current schedule
        return true;
    }
}
