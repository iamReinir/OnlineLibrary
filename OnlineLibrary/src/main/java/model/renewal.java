package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelSet.DatabaseUser;
import model_interface.Entity;

/**
 *
 * @author Ho Quoc Huy
 */
public class Renewal implements Entity {
    public String id = null;
    public String borrow_id = null;
    public String is_accept = null;
    public String accept_librarian_id = null;
    public String request_date = null;
    public String accept_date = null;
    public String is_delete = null;
    public String last_modified_at = null;

    public Renewal() {
    }

    public Renewal(String id, String borrow_id, String is_accept, String accept_librarian_id, String request_date, String accept_date, String last_modified_at) {
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
                return null;
        }
    }

    private boolean update(String attr_name, String value) {
        Connection con = DatabaseUser.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE book SET " + attr_name + "=? WHERE id_BOOK=?");
            stmt.setString(1, value);
            stmt.setString(2, id);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                return false; //Cannot change id of a record                
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
                return false; // This is updated via the delete() method
            case "last_modified_at":
                last_modified_at = value;
                break;
            default:
                return false;
        }
        update(attribute_name, value);
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
    public boolean delete(boolean is_delete) {
        this.is_delete = (is_delete ? "true" : "false");
        return is_delete;
    }

    @Override
    public boolean isDeleted() {
        return is_delete.equals("true");
    }
}
