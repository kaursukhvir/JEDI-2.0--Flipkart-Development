package com.flipkart.business;

import com.flipkart.DAO.GymCentreDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymCentreService {

    private static GymCentreDAO gymCentreDAO = new GymCentreDAO();
    private static ScheduleService scheduleService = new ScheduleService();

    public List<GymCentre> getAllCentres(String gymOwnerId) {
        return gymCentreDAO.getGymCentreList(gymOwnerId);
    }

    public List<GymCentre> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    public List<Slot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        gymCentreDAO.addGymCentre(gymCentre);

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

}
