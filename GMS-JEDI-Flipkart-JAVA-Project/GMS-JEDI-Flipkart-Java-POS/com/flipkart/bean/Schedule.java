package com.flipkart.bean;

import java.util.Date;

public class Schedule {

    private String scheduleID;

    private Date date;
    private String slotID;
    private int availablilty;

    public Schedule(String scheduleID, Date date, String slotID, int availablilty) {
        this.scheduleID = scheduleID;
        this.date = date;
        this.slotID = slotID;
        this.availablilty = availablilty;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public int getAvailablilty() {
        return availablilty;
    }

    public void setAvailablilty(int availablilty) {
        this.availablilty = availablilty;
    }


}
