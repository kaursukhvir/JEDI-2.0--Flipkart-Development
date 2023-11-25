package com.flipkart.constant;

public class SQLConstants {

    // ------- GYM OWNER -------
    public static final String FETCH_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.GymOwner";

    // isApproved: 0=not approved, 1=approved, 2=pending
    public static final String FETCH_ALL_PENDING_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.GymOwner where isApproved = 2";
    public static String SEND_GYM_OWNER_APPROVAL_REQ_QUERY(String gymOwnerId) {
        return "UPDATE FlipFit.GymOwner SET isApproved = 2 WHERE Id = \"" + gymOwnerId + "\";";
    }
}
