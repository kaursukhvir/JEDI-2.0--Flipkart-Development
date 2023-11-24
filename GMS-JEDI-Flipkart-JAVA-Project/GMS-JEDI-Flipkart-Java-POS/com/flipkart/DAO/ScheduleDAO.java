package com.flipkart.DAO;

import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDAO {

    private ArrayList<Schedule> schedulesCollection = new ArrayList<>();



    public void addSchedule(String scheduleID, Date date,String slotID, int availability){
        Schedule schedule = new Schedule(scheduleID,date,slotID,availability);
        schedulesCollection.add(schedule);
    }


    public List<Schedule> getAllScheduleByDate(Date date) {
        ArrayList<Schedule> response = new ArrayList<>();
        for(Schedule schedule: schedulesCollection){
            if(schedule.getDate() == date){
                response.add(schedule);
            }
        }
        return response;
    }
}
