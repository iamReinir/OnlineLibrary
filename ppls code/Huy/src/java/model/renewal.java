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
public class renewal implements Entity{
    public String id;
    public String borrow_id;
    public String is_accept;
    public String accept_librarian_id;
    public String request_date;
    public String accept_date;
    public String is_delete = "false";
    public String last_modified_at;

    public renewal() {
    }

    public renewal(String id, String borrow_id, String is_accept, String accept_librarian_id, String request_date, String accept_date, String last_modified_at) {
        this.id = id;
        this.borrow_id = borrow_id;
        this.is_accept = is_accept;
        this.accept_librarian_id = accept_librarian_id;
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

    public String getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(String borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getIs_accept() {
        return is_accept;
    }

    public void setIs_accept(String is_accept) {
        this.is_accept = is_accept;
    }

    public String getAccept_librarian_id() {
        return accept_librarian_id;
    }

    public void setAccept_librarian_id(String accept_librarian_id) {
        this.accept_librarian_id = accept_librarian_id;
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
        return "renewal";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id",
            "borrow_id",
            "is_accept",
            "accept_librarian_id",
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
            case "borrow_id":
                return borrow_id;
            case "is_accept":
                return is_accept;
            case "accept_librarian_id":
                return accept_librarian_id;
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
                        + "I suggest you provide me with the id "
                        + "so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "borrow_id":
                borrow_id = value;
                break;
            case "is_accept":
                is_accept = value;
                break;
            case "accept_librarian_id":
                accept_librarian_id = value;
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
