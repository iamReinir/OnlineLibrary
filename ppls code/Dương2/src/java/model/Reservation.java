/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private int id;
    private int user_id;
    private int book_id;
    private boolean is_accept;
    private Date request_date;
    private Date accept_date;
    private boolean is_delete;
     private Date last_modified_at;

    public Reservation() {
    }

    public Reservation(int id, int user_id, int book_id, boolean is_accept, Date request_date, Date accept_date, boolean is_delete, Date last_modified_at) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.is_accept = is_accept;
        this.request_date = request_date;
        this.accept_date = accept_date;
        this.is_delete = is_delete;
        this.last_modified_at = last_modified_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public boolean isIs_accept() {
        return is_accept;
    }

    public void setIs_accept(boolean is_accept) {
        this.is_accept = is_accept;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public Date getAccept_date() {
        return accept_date;
    }

    public void setAccept_date(Date accept_date) {
        this.accept_date = accept_date;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public Date getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(Date last_modified_at) {
        this.last_modified_at = last_modified_at;
    }
     
     
}
