package main.java.com.flipkart.DAO;

import main.java.com.flipkart.bean.Slot;

import java.util.List;

public interface SlotInterfaceDAO {
    public List<Slot> getSlotList();
    public List<Slot> getSlotByCentreId(String gymCentreId);
    public void addSlot(Slot slot);
    public Slot getSlotById(String slotID);
    public Slot getSlotByIdandCentreId(String slotID, String gymCentreId);
}
