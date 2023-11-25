package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCentreInterfaceDAO {

    public List<GymCentre> getGymCentreList();
    public void setGymCentreList(List<GymCentre> gymCentreList);
    public GymCentre getGymCentre(String gymCentreId) throws Exception;
    public void addGymCentre(GymCentre centre);
    public List<GymCentre> getPendingGymCentreList();
    public void setPendingGymCentreList(List<GymCentre> pendingGymCentreList);
    public void validateGymCentre(String gymCentreId, boolean isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<GymCentre> getGymCentreListByCity(String city);
}
