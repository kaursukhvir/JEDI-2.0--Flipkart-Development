package com.flipkart.DAO;

import com.flipkart.bean.Slot;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SlotDAO {
    List<Slot> slotList = new ArrayList<>();



    public SlotDAO(){
        Slot slot1 = new Slot("1", LocalTime.parse("06:00:00"));
        Slot slot2 = new Slot("1", LocalTime.parse("07:00:00"));
        Slot slot3 = new Slot("1", LocalTime.parse("08:00:00"));
        Slot slot4 = new Slot("2", LocalTime.parse("05:00:00"));
        Slot slot5 = new Slot("3", LocalTime.parse("12:00:00"));
        Slot slot6 = new Slot("3", LocalTime.parse("14:00:00"));

        this.slotList.add(slot1);
        this.slotList.add(slot2);
        this.slotList.add(slot3);
        this.slotList.add(slot4);
        this.slotList.add(slot5);
        this.slotList.add(slot6);
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }
    public List<Slot> getSlotList() {
        return slotList;
    }

    public List<Slot> getSlotByCentreId(String gymCentreId){
        List<Slot> resSlotList = new ArrayList<>();
        for(Slot slot : this.slotList){
            if(slot.getCentreID().equals(gymCentreId))
                resSlotList.add(slot);
        }

        return resSlotList;
    }

    public void addSlot(Slot slot){
        this.slotList.add(slot);
    }


}
