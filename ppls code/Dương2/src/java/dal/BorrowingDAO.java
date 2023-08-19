/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Borrowing;

/**
 *
 * @author Lenovo
 */
public class BorrowingDAO extends DBContext{
    public List<Borrowing> getAllBorrowingBookByBorrowerID(int id) {
        List<Borrowing> list = new ArrayList<>();
        String sql = "select * from Borrowing where borrower_id = ? and return_date is null";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {  
                Borrowing b = new Borrowing(rs.getInt("id"),
                        rs.getInt("borrower_id"),
                        rs.getString("borrower_book"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("return_date"),
                        rs.getDate("last_modified_at"),
                        rs.getBoolean("is_delete"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Borrowing> getAllBorrowedBookByBorrowerID(int id) {
        List<Borrowing> list = new ArrayList<>();
        String sql = "select * from Borrowing where borrower_id = ? and return_date is not null";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {  
                Borrowing b = new Borrowing(rs.getInt("id"),
                        rs.getInt("borrower_id"),
                        rs.getString("borrower_book"),
                        rs.getDate("start_date"),
                        rs.getDate("due_date"),
                        rs.getDate("return_date"),
                        rs.getDate("last_modified_at"),
                        rs.getBoolean("is_delete"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
