package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelSet.DatabaseUser;
import model_interface.Entity;

/**
 *
 * @author Ho Quoc Huy - edit : Nguyen Xuan Trung
 */
public class Borrowing implements Entity {

    public String id = null;
    public String borrower_id = null;
    public String borrowed_book = null;
    public String start_date = null;
    public String due_date = null;
    public String return_date = null;
    public String last_modified_at = null;
    public String is_delete = "false";

    public Borrowing() {
    }

    public Borrowing(String id, String borrower_id, String borrowed_book, String start_date,
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
        String res = null;
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
                return null;
        }
    }

    private boolean update(String attr_name, String value) {
        Connection con = DatabaseUser.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE borrowing SET " + attr_name + "=? WHERE borrow_id=?");
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
        String attr = attribute_name;
        switch (attribute_name) {
            case "id":
                // cannot change a record's id
                break;
            case "borrower_id":
                borrower_id = value;
                break;
            case "borrowed_book":
                borrowed_book = value;
                attr = "id_BOOK"; // the column in database is different
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
                // update via the delete() method
                break;
            default:
                return false;
        }
        if (id != null) {
            return update(attr, value);
        }
        return true;
    }

    @Override
    public boolean setAttributes(String[] attribute_names, String[] values) {
        for (int i = 0; i <= attribute_names.length; i++) {
            if (!setAttribute(attribute_names[i], values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(boolean is_delete) {
        this.is_delete = (is_delete ? "true" : "false");
        if (id == null) {
            return true;
        }
        Connection con = DatabaseUser.getConnection();
        try {
            PreparedStatement stmt = con
                    .prepareStatement("UPDATE borrowing SET is_delete=? WHERE borrow_id=?");
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
