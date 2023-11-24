package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class GymCentreDAO {

    private static List<GymCentre>  gymCentreList = new ArrayList<>();
    private static List<GymCentre>  pendingGymCentreList = new ArrayList<>();

    public GymCentreDAO() {

        GymCentre gym1 = new GymCentre("gym1","cultfit", "1", "Bangalore", 10);
        GymCentre gym2 = new GymCentre("gym2","gold's", "1", "Bangalore", 10);
        GymCentre gym3 = new GymCentre("gym3","jimmy", "2", "Delhi", 12);
        GymCentre gym4 = new GymCentre("gym4","shimmy", "2", "Delhi", 12);
        GymCentre gym5 = new GymCentre("gym5","brimmy", "3", "Pune", 15);

        gymCentreList.add(gym1);
        gymCentreList.add(gym2);
        gymCentreList.add(gym3);
        gymCentreList.add(gym4);
        gymCentreList.add(gym5);

    }

    public List<GymCentre> getGymCentreList() {
        return gymCentreList;
    }

    public void setGymCentreList(List<GymCentre> gymCentreList) {
        this.gymCentreList = gymCentreList;
    }

    public GymCentre getGymCentre(String gymCentreId) throws Exception {
        for(GymCentre gym : gymCentreList) {
            if(gym.getGymCentreID().equals(gymCentreId)) return gym;
        }
        throw new Exception("Gym Not Found");
    }

    public void addGymCentre(GymCentre centre) {
        this.gymCentreList.add(centre);
    }

    public List<GymCentre> getPendingGymCentreList() {
        return pendingGymCentreList;
    }

    public void setPendingGymCentreList(List<GymCentre> pendingGymCentreList) {
        this.pendingGymCentreList = pendingGymCentreList;
    }

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        for(GymCentre gymCentre : gymCentreList) {
            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
                gymCentre.setApproved(isApproved);
            }
        }
        for(GymCentre gymCentre : pendingGymCentreList) {
            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
                pendingGymCentreList.remove(gymCentre);
            }
        }
    }

    public void sendCentreApprovalRequest(String gymCentreId){
        for( GymCentre gymCentre : gymCentreList ){
            if(gymCentre.getGymCentreID().equals(gymCentreId)){
                pendingGymCentreList.add(gymCentre);
                break;
            }
        }
    }

    public List<GymCentre> getGymCentreListByCity(String city) {
        List<GymCentre> allCentreByCity = new ArrayList<>();
        for(GymCentre gymCentre: gymCentreList){
            if(gymCentre.getCity().equals(city)){
                allCentreByCity.add(gymCentre);
            }
        }
        return allCentreByCity;
    }
}
