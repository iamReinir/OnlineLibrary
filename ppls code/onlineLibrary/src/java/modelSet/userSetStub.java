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
import model.user;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author PC
 */
public class userSetStub implements EntitySet{
    ArrayList<user> list;
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
    public userSetStub() {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String query = "select * from library.user";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            user u = new user();
            u.setId(rs.getString(1));
            u.setUsername(rs.getString(2));
            u.setPassword(rs.getString(3));
            u.setEmail(rs.getString(4));
            u.setTelephone_number(rs.getString(5));
            u.setRole(rs.getString(6));
            u.setIs_delete(rs.getString(7));
            u.setRegister_date(rs.getString(8));
            u.setLast_modified_at(rs.getString(9));
            list.add(u);
            
        } catch (Exception e) {
        }
    }
//===================================================================================================================
    @Override
    public String getType() {
        return "renewal";
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

    
    public boolean add(user u) {
        loadDriver(dbDriver);
        Connection con = getConnection();
	String sql = "insert into library.user values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getId());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getTelephone_number());
            ps.setString(6, u.getRole());
            ps.setString(7, u.getIs_delete());
            ps.setString(8, u.getRegister_date());
            ps.setString(9, u.getLast_modified_at());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
