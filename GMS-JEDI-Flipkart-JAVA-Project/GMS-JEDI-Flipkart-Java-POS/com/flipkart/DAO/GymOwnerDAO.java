package com.flipkart.DAO;

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

public class GymOwnerDAO implements GymOwnerInterfaceDAO{

    Connection conn = null;
    PreparedStatement statement = null;
    private List<GymOwner> gymOwnerList = new ArrayList<>();
    private List<GymOwner> pendingGymOwnerList = new ArrayList<>();


    public GymOwnerDAO() {
//        setPendingGymOwnerList();
    }
    public List<GymOwner> getGymOwnerList() {

        List<GymOwner> resGymOwnerList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching all gym owners..");

            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_GYM_OWNERS_QUERY);

            ResultSet rs = statement.executeQuery();
//            System.out.println(rs);
            while(rs.next()) {
                GymOwner owner = new GymOwner(rs.getString("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"), Role.GYMOWNER, rs.getString("panNumber"), rs.getString("cardDetails"));
                resGymOwnerList.add(owner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setGymOwnerList(resGymOwnerList);
        return gymOwnerList;
    }

    public void setGymOwnerList(List<GymOwner> gymOwnerList) {
        this.gymOwnerList = gymOwnerList;
    }

    public void registerGymOwner(GymOwner gymOwner){
        this.gymOwnerList.add(gymOwner);
    }

    public List<GymOwner> getPendingGymOwnerList() {

        List<GymOwner> pendingList = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gym owners..");

            statement = conn.prepareStatement(SQLConstants.FETCH_ALL_PENDING_GYM_OWNERS_QUERY);

            ResultSet rs = statement.executeQuery();
            System.out.println(rs);
            while(rs.next()) {
                GymOwner owner = new GymOwner(rs.getString("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"), Role.GYMOWNER, rs.getString("panNumber"), rs.getString("cardDetails"));
                pendingList.add(owner);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return pendingList;
    }

    public void sendOwnerApprovalRequest(String gymOwnerId){

        try {
            conn = DBConnection.connect();
            System.out.println("Sending gym owner approval request..");
            statement = conn.prepareStatement(SQLConstants.SEND_GYM_OWNER_APPROVAL_REQ_QUERY(gymOwnerId));
            statement.executeUpdate();

        } catch (SQLException se) { se.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
    }
    public void setPendingGymOwnerList(){}

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        for(GymOwner gymOwner : gymOwnerList) {
            if(gymOwner.getUserID().equals(gymOwnerId)) {
                gymOwner.setApproved(isApproved);
            }
        }
        for(GymOwner gymOwner : pendingGymOwnerList) {
            if(gymOwner.getUserID().equals(gymOwnerId)) {
                pendingGymOwnerList.remove(gymOwner);
            }
        }
    }
}
