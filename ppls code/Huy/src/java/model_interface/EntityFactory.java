/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class EntityFactory {
    private String dbUrl = "jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String dbUname = "root";
    private String dbPassword = "123456";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    
        public static void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//===================================================================================================================	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
//===================================================================================================================      
    
    public String[] getEntityTypeName(){
        return new String[]{
            "book",
            "user",
            "borrowing",
            "reservation",
            "renewal",
            "review"
        };
    }
    
    public EntitySet getEntitySet(String entity_type){
        
        return null;
    }
   
    public Entity createEntity(String entity_type){
        loadDriver(dbDriver);
	Connection con = getConnection();
        if(entity_type.equals(entity_type)){
            String query = "insert into library.book values(?,?,?,?,?,?,?,?)";
            
            
        }
        return null; 
    }

}
