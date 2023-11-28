package main.java.com.flipkart.business;

import main.java.com.flipkart.bean.Slot;

import java.util.List;

public interface SlotServiceInterface {
    List<Slot> getAllSlotsByCentre(String centreID);
    Slot getSlotByID(String slotID);
    List<Slot> getSlotList();
    void addSlotsForGym(String gymCentreId, List<Slot> slotList);
    boolean isSlotValid(String slotID,String centreId);
}
