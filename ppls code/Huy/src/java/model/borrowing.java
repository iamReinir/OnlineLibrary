/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model_interface.Entity;

/**
 *
 * @author PC
 */
public class borrowing implements Entity{
    public String id;
    public String borrower_id;
    public String borrowed_book;
    public String start_date;
    public String due_date;
    public String return_date;
    public String last_modified_at;
    public String is_delete = "false";

    public borrowing() {
    }

    public borrowing(String id, String borrower_id, String borrowed_book, String start_date, 
            String due_date, String return_date, String last_modified_at, String is_delete) {
        this.id = id;
        this.borrower_id = borrower_id;
        this.borrowed_book = borrowed_book;
        this.start_date = start_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.last_modified_at = last_modified_at;
        this.is_delete = is_delete;
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

    public String getBorrowed_book() {
        return borrowed_book;
    }

    public void setBorrowed_book(String borrowed_book) {
        this.borrowed_book = borrowed_book;
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

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }
    
    
    
    @Override
    public String getType() {
        return "borrowing";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id" +
            "borrower_id",
            "borrowed_book",
            "start_date",
            "due_date",
            "return_date",
            "last_modified_at",
            "is_delete"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "borrower_id":
                return borrower_id;
            case "borrowed_book":
                return borrowed_book;
            case "start_date":
                return start_date;
            case "due_date":
                return due_date;
            case "return_date":
                return return_date;
            case "last_modified_at":
                return last_modified_at;
            case "is_delete":
                return is_delete;
            default:
                return "------ I’m sorry but I’m not sure what you’re asking for. "
                        + "Could you please clarify your request? "
                        + "If you’re looking for a summary of a user, "
                        + "I suggest you provide me with the id "
                        + "and borrower id so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "borrower_id":
                borrower_id = value;
                break;
            case "borrowed_book":
                borrowed_book = value;
                break;
            case "start_date":
                start_date = value;
                break;
            case "due_date":
                due_date = value;
               break;
            case "return_date":
                return_date = value;
                break;
            case "last_modified_at":
                last_modified_at = value;
                break;
            case "is_delete":
                is_delete = value;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean setAttributes(String[] attribute_names, String[] values) {
        if(attribute_names.length == values.length){
            for(int i = 0; i <= attribute_names.length; i++){
                attribute_names[i] = values[i];
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete() {
        is_delete = "true";
        return true;
    }

    @Override
    public boolean undelete() {
        is_delete = "false";
        return false;
    }
}
