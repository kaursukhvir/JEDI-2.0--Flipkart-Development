package com.flipkart.DAO;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymCentreDAO implements GymCentreInterfaceDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;
    private static List<GymCentre>  gymCentreList = new ArrayList<>();
    private static List<GymCentre>  pendingGymCentreList = new ArrayList<>();

    public GymCentreDAO() {
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
        List<GymCentre> pendingList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gym centres..");

            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_PENDING_GYM_CENTRES_QUERY);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                //GymOwner owner = new GymOwner(rs.getString("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"), Role.GYMOWNER, rs.getString("panNumber"), rs.getString("cardDetails"));
                GymCentre gymCentre = new GymCentre(rs.getString("centreId"),rs.getString("centreName"),rs.getString("ownerId"),rs.getString("city"),rs.getInt("capacity"));
                pendingList.add(gymCentre);
            }
            //conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return pendingList;
    }

    public void setPendingGymCentreList(List<GymCentre> pendingGymCentreList) {
        this.pendingGymCentreList = pendingGymCentreList;
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
        System.out.println("IN VALIDATE GYM CENTRE");
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centres..");

            statement = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY);
            statement.setInt(1, isApproved);
            statement.setString(2, gymCentreId);
            statement.executeUpdate();
            System.out.println("The gym centre has been approved!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
//        for(GymCentre gymCentre : gymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                gymCentre.setApproved(isApproved);
//            }
//        }
//        for(GymCentre gymCentre : pendingGymCentreList) {
//            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//                pendingGymCentreList.remove(gymCentre);
//            }
//        }
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
