package com.flipkart.business;

import com.flipkart.DAO.AdminDAO;
import com.flipkart.DAO.AdminInterfaceDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class AdminService {

    AdminInterfaceDAO adminDAO  = new AdminDAO();

    private List<GymOwner> pendinGymOwnerList = adminDAO.getPendingGymOwners();
    private List<GymCentre> pendinGymCentreList = adminDAO.getPendingGymCentres();

    public Object approveGymCenter(){
        //takes GymCenter Object as input and return boolean
        System.out.println("Approved/Rejected Gym Center: ");
        return new Object();
    }

    public Object approveGymOwner(){
        //takes GymOwner Object as input and return boolean
        System.out.println("Approved/Rejected Gym Owner: ");
        return new Object();
    }

    public List<GymCentre> viewPendingGymCentres(){
        //views all pending requests
        //System.out.println("Viewing pending Gym Center Approvals: ");
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");
        return pendinGymOwnerList;
    }

//    public Object addAdmin(String userName, String email, String password, Role role){
//        //takes username and password, verifies role and redirects to admin home
//        System.out.println("Successful login for Admin");
//        return new Object();
//    }

//    public void registerAdmin(String userName, String password, String email) {
//    }
}
