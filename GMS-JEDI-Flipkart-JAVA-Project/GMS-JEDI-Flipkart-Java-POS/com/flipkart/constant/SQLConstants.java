package com.flipkart.constant;

public class SQLConstants {

    // ------------------------ GYM OWNER ------------------------
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.GymOwner";
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.GymOwner where isApproved = 2";
    public static final String SEND_GYM_OWNER_APPROVAL_REQ_QUERY = "UPDATE FlipFit.GymOwner SET isApproved = 2 WHERE Id =?;";


    //    INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved)
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";



    //  ------------ GYM OWNER ------------
    public static final String REGISTER_GYM_OWNER = "Insert into GymOwner values (?,?,?,?,?,?,?)";
    public static final String LOGIN_GYM_OWNER = "Select * from GymOwner where Id=? and password=?";
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY="Update GymOwner Set isApproved=? WHERE Id=?";


    // ------------------------ GYM CENTRE ------------------------
    public static final String FETCH_GYM_CENTRES_BY_OWNER_ID = "SELECT * FROM FlipFit.GymCentre where ownerId = ?";
    public static final String FETCH_ALL_PENDING_GYM_CENTRES_QUERY = "SELECT * FROM FlipFit.GymCentre where isApproved = 2";
    public static final String ADD_GYM_CENTRE_QUERY = "INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update GymCentre Set isApproved=? WHERE centreId=?";
    public static final String SQL_APPROVE_GYM_OWNER_BY_ID_QUERY = "Update GymOwner Set isApproved=? WHERE Id=?";
    public static final String SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY = "Update GymCentre Set isApproved=? WHERE centreId=?";



    // ------------------------ CUSTOMER ------------------------
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFit.GymCentre (userId,userName,password,email,phoneNumber,cardNumber) VALUES (?, ?, ?, ?, ?, ?);";






    //    ------- Customer ---------------
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFit.Customer WHERE name = ? AND password = ?";
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFit.Customer (Id,name,password,email,phone,cardDetails) VALUES (?, ?, ?, ?, ?, ?);";
}
