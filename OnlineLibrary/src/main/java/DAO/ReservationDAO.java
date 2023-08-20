/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Huynh Thai Duong
 */
public class ReservationDAO {

    public List<Reservation> getAllReservationByUserID(int id) {
        List<Reservation> list = new ArrayList<>();
        Entity[] reservation = EntityFactory.getEntitySet("reservation").searchResult(br -> {
            return br.getAttribute("user_id").equals(String.valueOf(id));
        });
        for (Entity e : reservation) {
            System.out.println(e.getAttribute("request_date"));
            list.add(new Reservation(
                    e.getAttribute("id"),
                    e.getAttribute("user_id"),
                    e.getAttribute("book_id"),
                    e.getAttribute("is_accept"),
                    e.getAttribute("request_date"),
                    e.getAttribute("accept_date"),
                    e.isDeleted(),
                    e.getAttribute("last_modified_at")
            ));
        }
        return list;
    }

    // Author : Nguyen Xuan Trung
    // Method for integration
    public static String usernameOf(Reservation re) {
        Entity bdReservate = EntityFactory.getEntitySet("reservation").getEntity(re.getId());
        return EntityFactory
                .getEntitySet("user")
                .getEntity(bdReservate.getAttribute("user_id"))
                .getAttribute("username");
    }

    public static String bookNameOf(Reservation re) {
        Entity bdReservate = EntityFactory.getEntitySet("reservation").getEntity(re.getId());
        return EntityFactory
                .getEntitySet("book")
                .getEntity(bdReservate.getAttribute("book_id"))
                .getAttribute("title");
    }

}
