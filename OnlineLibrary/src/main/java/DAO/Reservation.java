/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private String id;
    private String user_id;
    private String book_id;
    private String is_accept;
    private String request_date;
    private String accept_date;
    private boolean is_delete;
    private String last_modified_at;

    public Reservation() {
    }

    public Reservation(String id, String user_id, String book_id, String is_accept, String request_date, String accept_date, boolean is_delete, String last_modified_at) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.is_accept = is_accept;
        this.request_date = request_date;
        this.accept_date = accept_date;
        this.is_delete = is_delete;
        this.last_modified_at = last_modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getIs_accept() {
        return is_accept;
    }

    public void setIs_accept(String is_accept) {
        this.is_accept = is_accept;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getAccept_date() {
        return accept_date;
    }

    public void setAccept_date(String accept_date) {
        this.accept_date = accept_date;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(String last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

     
}
