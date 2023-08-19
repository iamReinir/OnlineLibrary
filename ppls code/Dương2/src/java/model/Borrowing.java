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
public class Borrowing {
    private int id;
    private int borrower_id;
    private String borrower_book;
    private Date start_date;
    private Date due_date;
    private Date return_date;
    private Date last_modified_at;
    private boolean is_delete;

    public Borrowing() {
    }

    public Borrowing(int id, int borrower_id, String borrower_book, Date start_date, Date due_date, Date return_date, Date last_modified_at, boolean is_delete) {
        this.id = id;
        this.borrower_id = borrower_id;
        this.borrower_book = borrower_book;
        this.start_date = start_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.last_modified_at = last_modified_at;
        this.is_delete = is_delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(int borrower_id) {
        this.borrower_id = borrower_id;
    }

    public String getBorrower_book() {
        return borrower_book;
    }

    public void setBorrower_book(String borrower_book) {
        this.borrower_book = borrower_book;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(Date last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

    public boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean     is_delete) {
        this.is_delete = is_delete;
    }
    
    
}
