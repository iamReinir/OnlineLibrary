/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


/**
 *
 * @author Lenovo
 */
public class Borrowing {
    private String id;
    private String borrower_id;
    private String borrower_book;
    private String start_date;
    private String due_date;
    private String return_date;
    private String last_modified_at;
    private boolean is_delete;

    public Borrowing(String id, String borrower_id, String borrower_book, String start_date, String due_date, String return_date, String last_modified_at, boolean is_delete) {
        this.id = id;
        this.borrower_id = borrower_id;
        this.borrower_book = borrower_book;
        this.start_date = start_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.last_modified_at = last_modified_at;
        this.is_delete = is_delete;
    }
    public Borrowing() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(String borrower_id) {
        this.borrower_id = borrower_id;
    }

    public String getBorrower_book() {
        return borrower_book;
    }

    public void setBorrower_book(String borrower_book) {
        this.borrower_book = borrower_book;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(String last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    
}
