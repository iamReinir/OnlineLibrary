package modelSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Review;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Ho Quoc Huy - edit Nguyen Xuan Trung
 */
public class ReviewSet implements EntitySet {

    ArrayList<Review> list = new ArrayList<>();

    public ReviewSet() {
        Connection con = DatabaseUser.getConnection();
        String query = "select * from library.review";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review r = new Review();
                r.setId(rs.getString(1));
                r.setBook_id(rs.getString(2));
                r.setUser_id(rs.getString(3));
                r.setRating(rs.getString(4));
                r.setUser_review(rs.getString(5));
                r.setReview_date(rs.getString(6));
                r.setLast_modified_at(rs.getString(7));
                list.add(r);
            }

        } catch (Exception e) {
        }
    }
//===================================================================================================================

    @Override
    public String getType() {
        return "review";
    }

    @Override
    public Entity getEntity(String id) {
        try {
            return list.get(Integer.parseInt(id));
        } catch (Exception e) {
            return null;
        }
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
        String sql = "insert into library.review"
                + "(id_BOOK, id_user, rating, user_review)"
                + "values(?,?,?,?)";
        PreparedStatement ps;
        try {
            Review r = (Review) newE;
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getBook_id());
            ps.setString(2, r.getUser_id());
            ps.setString(3, r.getRating());
            ps.setString(4, r.getUser_review());
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
