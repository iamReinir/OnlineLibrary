/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.book;
import model.borrowing;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author PC
 */
public class borrowingSetStub implements EntitySet{
    ArrayList<borrowing> list;
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
    public borrowingSetStub() {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String query = "select * from library.borrowing";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            borrowing b = new borrowing();
            b.setId(rs.getString(1));
            b.setBorrower_id(rs.getString(2));
            b.setBorrowed_book(rs.getString(3));
            b.setStart_date(rs.getString(4));
            b.setDue_date(rs.getString(5));
            b.setReturn_date(rs.getString(6));
            b.setLast_modified_at(rs.getString(7));
            b.setIs_delete(rs.getString(8));
            list.add(b);
            
        } catch (Exception e) {
        }
    }
//===================================================================================================================
    @Override
    public String getType() {
        return "borrowing";
    }

    @Override
    public Entity getEntity(String id) {
        try {
            return list.get(Integer.parseInt(id));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Entity[] searchResult(String attribute, Predicate<String> search_function) {
        ArrayList<Entity> res = new ArrayList<>();
        Entity[] everything = all();
        for (Entity x : everything) {
            if (search_function.test(x.toString()) == true) {
                res.add(x);
            }
        }
        Entity[] ret = new Entity[res.size()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    @Override
    public Entity[] all() {
        for(int i = 0; i <= list.size(); i++){
            return new Entity[]{
                list.get(i)
            };
        }
        return null;
    }

    
    public boolean add(borrowing b) {
        loadDriver(dbDriver);
        Connection con = getConnection();
	String sql = "insert into library.borrowing values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getId());
            ps.setString(2, b.getBorrower_id());
            ps.setString(3, b.getBorrowed_book());
            ps.setString(4, b.getStart_date());
            ps.setString(5, b.getDue_date());
            ps.setString(6, b.getReturn_date());
            ps.setString(7, b.getLast_modified_at());
            ps.setString(8, b.getIs_delete());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
