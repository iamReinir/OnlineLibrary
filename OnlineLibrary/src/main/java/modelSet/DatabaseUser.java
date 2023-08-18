/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giga P34
 */
public class DatabaseUser {

    static public String dbUrl = "jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static public String username = "onlLib";
    static public String password = "123456";
    static public String dbDriver = "com.mysql.cj.jdbc.Driver";
    static public Connection con = null;

    static public Connection getConnection() {
        if (con != null) {
            return con;
        }
        loadDriver(dbDriver);
        try {
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Error in DatabaseUser getConnection()");
            e.printStackTrace();
        }
        return con;
    }

    public static void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
