package com.flipkart.DAO;

import com.flipkart.bean.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleInterfaceDAO {
    public void addSchedule(String scheduleID, Date date, String slotID, int availability);
    public List<Schedule> getAllScheduleByDate(Date date);

}
