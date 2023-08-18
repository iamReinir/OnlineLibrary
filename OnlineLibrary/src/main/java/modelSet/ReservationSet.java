package modelSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Reservate;
import model_interface.*;


/**
 *
 * @author Ho Quoc Huy - edit Nguyen Xuan Trung
 */
public class ReservationSet implements EntitySet {

    ArrayList<Reservate> list = new ArrayList<>();

    public ReservationSet() {
        Connection con = DatabaseUser.getConnection();
        String query = "select * from library.reservation";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservate r = new Reservate();
                r.setId(rs.getString(1));
                r.setUser_id(rs.getString(2));
                r.setBook_id(rs.getString(3));
                r.setIs_accept(rs.getString(4));
                r.setRequest_date(rs.getString(5));
                r.setAccept_date(rs.getString(6));
                r.setLast_modified_at(rs.getString(7));
                list.add(r);
            }

        } catch (Exception e) {
        }
    }
//===================================================================================================================

    @Override
    public String getType() {
        return "reservation";
    }

    @Override
    public Entity getEntity(String id) {
        for (Reservate x : list) {
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

    @Override
    public boolean add(Entity newE) {
        Connection con = DatabaseUser.getConnection();
        String sql = "insert into library.reservation "
                + "(id_user, id_BOOK)"
                + "values(?,?)";
        PreparedStatement ps;
        try {
            Reservate r = (Reservate) newE;
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getUser_id());
            ps.setString(2, r.getBook_id());
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
