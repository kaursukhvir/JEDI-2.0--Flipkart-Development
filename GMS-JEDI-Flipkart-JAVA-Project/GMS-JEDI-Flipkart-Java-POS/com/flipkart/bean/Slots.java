package com.flipkart.bean;

import java.time.LocalTime;
import java.util.Date;

public class Slots {
    private String slotId;
    private String centreID;
    private LocalTime time;

    public Slots( String centreID, LocalTime time) {
        this.centreID = centreID;
        this.time = time;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getCentreID() {
        return centreID;
    }

    public void setCentreID(String centreID) {
        this.centreID = centreID;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
