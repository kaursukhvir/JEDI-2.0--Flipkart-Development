package com.flipkart.DAO;

import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDAO implements ScheduleInterfaceDAO {

    public void addSchedule(String scheduleID, Date date, String slotID, int availability){
        Schedule schedule = new Schedule(scheduleID,date,slotID,availability);
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SCHEDULE);
            ps.setString(1, scheduleID);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setString(3, slotID);
            ps.setInt(4, availability);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Schedule getSchedule(String scheduleId){
        Schedule schedule = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULE_BY_ID);
            ps.setString(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("'availability");
                Date date = new Date(rs.getDate("date").getTime());
                schedule = new Schedule(scheduleId, date, slotId, availability);
            }
            if(schedule == null)
                throw new SQLException("Not Found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schedule;
    }

    public List<Schedule> getAllScheduleByDate(Date date) {
        ArrayList<Schedule> response = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_DATE);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String scheduleId = rs.getString("scheduleId");
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("'availability");

                response.add(new Schedule(scheduleId, date, slotId, availability));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public void modifySchedule(String scheduleId,int action){
        //1 for increasing, -1 for decreasing
        try{
            Connection conn = DBConnection.connect();
            int availability = getSchedule(scheduleId).getAvailability();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.MODIFY_SCHEDULE_AVAILABILITY);
            ps.setInt(1, availability+action);
            ps.setString(2, scheduleId);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
