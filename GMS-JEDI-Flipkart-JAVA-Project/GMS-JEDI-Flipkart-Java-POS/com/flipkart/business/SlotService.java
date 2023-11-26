package com.flipkart.business;

import com.flipkart.DAO.SlotDAO;
import com.flipkart.bean.Slot;

import java.util.List;

public class SlotService {
    private static SlotDAO slotDAO = new SlotDAO();


    public void addSlot(Slot slot){
        slotDAO.addSlot(slot);
    }

    public List<Slot> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public Slot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }
    public List<Slot> getSlotList(){
        return slotDAO.getSlotList();
    }
}
