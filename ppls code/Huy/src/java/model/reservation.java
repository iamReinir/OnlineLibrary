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
public class reservation implements Entity{
    public String id;
    public String user_id;
    public String book_id;
    public String is_accept;
    public String request_date;
    public String accept_date;
    public String is_delete = "false";
    public String last_modified_at;

    public reservation() {
    }

    public reservation(String id, String user_id, String book_id, String is_accept,
            String request_date, String accept_date, String last_modified_at) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.is_accept = is_accept;
        this.request_date = request_date;
        this.accept_date = accept_date;
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

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(String last_modified_at) {
        this.last_modified_at = last_modified_at;
    }
    
    

    @Override
    public String getType() {
        return "reservation";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id",
            "user_id",
            "book_id",
            "is_accept",
            "request_date",
            "accept_date",
            "is_delete",
            "last_modified_at"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "user_id":
                return user_id;
            case "book_id":
                return book_id;
            case "is_accept":
                return is_accept;
            case "request_date":
                return request_date;
            case "accept_date":
                return accept_date;
            case "is_delete":
                return is_delete;
            case "last_modified_at":
                return last_modified_at;
            default:
                return "------ I’m sorry but I’m not sure what you’re asking for. "
                        + "Could you please clarify your request? "
                        + "If you’re looking for a summary of a user, "
                        + "I suggest you provide me with the id, user_id and book id "
                        + "so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "user_id":
                user_id = value;
                break;
            case "book_id":
                book_id = value;
                break;
            case "is_accept":
                is_accept = value;
                break;
            case "request_date":
                request_date = value;
               break;
            case "accept_date":
                accept_date = value;
                break;
            case "is_delete":
                is_delete = value;
                break;
            case "last_modified_at":
                last_modified_at = value;
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
