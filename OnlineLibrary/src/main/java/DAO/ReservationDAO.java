/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Lenovo
 */
public class ReservationDAO {

    public List<Reservation> getAllReservationByUserID(int id) {
        List<Reservation> list = new ArrayList<>();
        Entity[] reservation = EntityFactory.getEntitySet("reservation").searchResult(br -> {
            return br.getAttribute("user_id").equals(String.valueOf(id));
        });
        for (Entity e : reservation) {
            list.add(new Reservation(
                    Integer.parseInt(e.getAttribute("id")),
                    Integer.parseInt(e.getAttribute("user_id")),
                    Integer.parseInt(e.getAttribute("book_id")),
                    e.getAttribute("is_accept").equals("true"),
                    new Date(Date.parse(e.getAttribute("request_date"))),
                    new Date(Date.parse(e.getAttribute("accept_date"))),
                    e.isDeleted(),
                    new Date(Date.parse(e.getAttribute("last_modified_at")))
            ));
        }
        return list;
    }
    
}
