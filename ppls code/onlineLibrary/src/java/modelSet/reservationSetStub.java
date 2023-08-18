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
import model.renewal;
import model.reservation;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author PC
 */
public class reservationSetStub implements EntitySet{
    ArrayList<reservation> list;
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
    public reservationSetStub() {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String query = "select * from library.reservation";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            reservation r = new reservation();
            r.setId(rs.getString(1));
            r.setUser_id(rs.getString(2));
            r.setBook_id(rs.getString(3));
            r.setIs_accept(rs.getString(4));
            r.setRequest_date(rs.getString(5));
            r.setAccept_date(rs.getString(6));
            r.setLast_modified_at(rs.getString(7));
            list.add(r);
            
        } catch (Exception e) {
        }
    }
//===================================================================================================================
    @Override
    public String getType() {
        return "reservation";
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

    
    public boolean add(reservation r) {
        loadDriver(dbDriver);
        Connection con = getConnection();
	String sql = "insert into library.reservation values(?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getId());
            ps.setString(2, r.getUser_id());
            ps.setString(3, r.getBook_id());
            ps.setString(4, r.getIs_accept());
            ps.setString(5, r.getRequest_date());
            ps.setString(6, r.getAccept_date());
            ps.setString(7, r.getLast_modified_at());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
