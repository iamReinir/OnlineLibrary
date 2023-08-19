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
import model.Reservation;

/**
 *
 * @author Lenovo
 */
public class ReservationDAO extends DBContext{

    public List<Reservation> getAllReservationByUserID(int id) {
        List<Reservation> list = new ArrayList<>();
        String sql = "select * from Reservation where user_id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getBoolean("is_accept"),
                        rs.getDate("request_date"),
                        rs.getDate("accept_date"),
                        rs.getBoolean("is_delete"),
                        rs.getDate("last_modified_at"));
                list.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
}
