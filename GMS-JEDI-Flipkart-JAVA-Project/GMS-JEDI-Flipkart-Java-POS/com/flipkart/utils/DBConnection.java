package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    // Database credentials
    //  private static final String user   = "root";
    // private static final String pass  = "root";

    //    // Database credentials
    private static Connection single_instance = null;

    private static final String user   = "root";
    private static final String pass  = "";
    public static Connection connect() throws SQLException{

        if(single_instance==null){
            System.out.println("Connecting to DB....");
            // Register the jdbc driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/flipfit";//flipfit is the name of database 3306 is the port no. of mysql
                Connection connection = DriverManager.getConnection(url,user,pass);
                System.out.println("D atabase Connected");
                single_instance = connection;
                return connection;
            }
            catch (ClassNotFoundException ex){
                System.err.println("Could not find jdbc driver.");
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            return single_instance;
        }

        return null;
    }
}