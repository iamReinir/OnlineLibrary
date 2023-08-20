package modelSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Borrowing;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Ho Quoc Huy - edit : Nguyen Xuan Trung
 */
public class BorrowingSet implements EntitySet {

    ArrayList<Borrowing> list = new ArrayList<>();
    public BorrowingSet() {
        Connection con = DatabaseUser.getConnection();
        String query = "select * from library.borrowing";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Borrowing b = new Borrowing();
                b.setId(rs.getString(1));
                b.setBorrower_id(rs.getString(2));
                b.setBorrowed_book(rs.getString(3));
                b.setStart_date(rs.getString(4));
                b.setDue_date(rs.getString(5));
                b.setReturn_date(rs.getString(6));
                b.setLast_modified_at(rs.getString(7));
                b.setIs_delete(rs.getString(8).equals("1") ? "true" : "false");
                list.add(b);
            }
        } catch (Exception e) {
        }
    }
//===================================================================================================================

    @Override
    public String getType() {
        return "borrowing";
    }

    @Override
    public Entity getEntity(String id) {
        for (Borrowing x : list) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public Entity[] all() {
        if (list == null) {
            return new Entity[]{};
        }
        Entity[] result = new Entity[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // Note : insert date into database is kinda annoying to deal with.
    // This method will not work 
    // if the due_date does not exactly match with the database's datetime format
    @Override
    public boolean add(Entity b) {
        Connection con = DatabaseUser.getConnection();
        String sql = "insert into library.borrowing "
                + "(borrower_id, id_BOOK, due_date)"
                + "values(?,?,?)";
        PreparedStatement ps;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getAttribute("borrower_id"));
            ps.setString(2, b.getAttribute("borrowed_book"));
            // Turn the string into ulti.Date, return epoch time, use that to creat sql.Date
            ps.setDate(3, new Date(format.parse(b.getAttribute("return_date")).getTime()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Entity[] searchResult(Predicate<Entity> search_function) {
        ArrayList<Entity> res = new ArrayList<>();
        Entity[] everything = all();
        for (Entity x : everything) {
            if (search_function.test(x) == true) {
                res.add(x);
            }
        }
        Entity[] ret = new Entity[res.size()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = res.get(i);
        }
        return ret;
    }

}
