package com.flipkart.business;

import com.flipkart.DAO.SlotDAO;
import com.flipkart.bean.Slot;

public class SlotService {

    private static SlotDAO slotDAO = new SlotDAO();

    public void addSlot(Slot slot){
        slotDAO.addSlot(slot);
    }




}
