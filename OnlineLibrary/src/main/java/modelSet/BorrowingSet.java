package modelSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Book;
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
                b.setIs_delete(rs.getString(8));
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

    public boolean add(Borrowing b) {
        Connection con = DatabaseUser.getConnection();
        String sql = "insert into library.borrowing "
                + "(borrower_id, id_BOOK, due_date)"
                + "values(?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getId());
            ps.setString(2, b.getBorrower_id());
            ps.setString(3, b.getBorrowed_book());
            ps.setString(4, b.getStart_date());
            ps.setString(5, b.getDue_date());
            ps.setString(6, b.getReturn_date());
            ps.setString(7, b.getLast_modified_at());
            ps.setString(8, b.getIs_delete());
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

    @Override
    public boolean add(Entity new_entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
