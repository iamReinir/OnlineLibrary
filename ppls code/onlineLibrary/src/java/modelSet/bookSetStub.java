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
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author PC
 */
public class bookSetStub implements EntitySet{
    ArrayList<book> list;
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
    public bookSetStub() {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String query = "select * from library.book";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            book b = new book();
            b.setId(rs.getString(1));
            b.setIsbn(rs.getString(2));
            b.setTitle(rs.getString(3));
            b.setAuthor(rs.getString(4));
            b.setYear_of_pub(rs.getString(5));
            b.setDowload_link(rs.getString(6));
            b.setAdd_date(rs.getString(7));
            b.setIs_delete(rs.getString(8));
            b.setLast_modified_at(rs.getString(9));
            b.setSummary(rs.getString(10));
            list.add(b);
            
        } catch (Exception e) {
        }
    }
//===================================================================================================================
    @Override
    public String getType() {
        return "book";
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

    
    public boolean add(book b) {
        loadDriver(dbDriver);
        Connection con = getConnection();
	String sql = "insert into library.book values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getId());
            ps.setString(2, b.getIsbn());
            ps.setString(3, b.getTitle());
            ps.setString(4, b.getAuthor());
            ps.setString(5, b.getYear_of_pub());
            ps.setString(6, b.getDowload_link());
            ps.setString(7, b.getAdd_date());
            ps.setString(8, b.getIs_delete());
            ps.setString(9, b.getLast_modified_at());
            ps.setString(10, b.getSummary());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
