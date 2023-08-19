/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Book;

/**
 *
 * @author Lenovo
 */
public class BookDAO extends DBContext{
    public Book getBookByID(int id) {
        String sql = "select * from Book where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Book b = new Book(rs.getInt("id"),
                        rs.getString("ISBN"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year_of_pub"),
                        rs.getString("download_link"),
                        rs.getDate("add_date"),
                        rs.getBoolean("is_delete"),
                        rs.getDate("last_modified_at"),
                        rs.getString("summary"));
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
