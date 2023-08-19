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
import model.Borrowing;
import model.Renewal;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author PC
 */
public class RenewalSet implements EntitySet {
    ArrayList<Renewal> list;
    private String dbUrl = "jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String dbUname = "root";
    private String dbPassword = "Trung123";
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
    public RenewalSet() {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String query = "select * from library.renewal";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Renewal r = new Renewal();
            r.setId(rs.getString(1));
            r.setBorrow_id(rs.getString(2));
            r.setIs_accept(rs.getString(3));
            r.setAccept_librarian_id(rs.getString(4));
            r.setRequest_date(rs.getString(5));
            r.setAccept_date(rs.getString(6));
            r.setIs_delete(rs.getString(7));
            r.setLast_modified_at(rs.getString(8));
            list.add(r);
            
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
    public Entity[] all() {
        if (list == null) {
            return new Entity[]{};
        }
        Entity[] result = new Entity[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    
    public boolean add(Renewal r) {
        loadDriver(dbDriver);
        Connection con = getConnection();
	String sql = "insert into library.renewal values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getId());
            ps.setString(2, r.getBorrow_id());
            ps.setString(3, r.getIs_accept());
            ps.setString(4, r.getAccept_librarian_id());
            ps.setString(5, r.getRequest_date());
            ps.setString(6, r.getAccept_date());
            ps.setString(7, r.getIs_delete());
            ps.setString(8, r.getLast_modified_at());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Entity[] searchResult(Predicate<Entity> search_function) {
        ArrayList<Entity> res = new ArrayList<>();
        Entity[] everything = all();
        for (Entity x : everything) {
            if (search_function.test(x) == true) {
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
    public boolean add(Entity new_entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
