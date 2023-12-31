package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelSet.DatabaseUser;
import model_interface.Entity;

/**
 *
 * @author PC
 */
public class Reservate implements Entity {

    public String id = null;
    public String user_id = null;
    public String book_id = null;
    public String is_accept = null;
    public String request_date = null;
    public String accept_date = null;
    public String is_delete = "false";
    public String last_modified_at = null;

    public Reservate() {
    }

    public Reservate(String id, String user_id, String book_id, String is_accept,
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
                return null;
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                // Cannot change id
                return false;
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
                // change via the delete(boolean) method
                break;
            case "last_modified_at":
                last_modified_at = value;
                break;
            default:
                return false;
        }
        if (id != null)
            return update(attribute_name, value);
        return true;
    }

    private boolean update(String attr_name, String value) {
        Connection con = DatabaseUser.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE reservation SET " + attr_name + "=? reserve_id=?");
            stmt.setString(1, value);
            stmt.setString(2, id);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
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
    public boolean delete(boolean is_delete) {
        this.is_delete = (is_delete ? "true" : "false");
        if (id == null) {
            return true;
        }
        Connection con = DatabaseUser.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE reservation SET is_delete=? WHERE reserve_id=?");
            stmt.setBoolean(1, is_delete);
            stmt.setString(2, id);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean isDeleted() {
        return is_delete.equals("true");
    }
}
