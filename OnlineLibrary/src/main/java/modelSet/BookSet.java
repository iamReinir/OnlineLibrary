package modelSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Book;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Ho Quoc Huy - edit: Nguyen Xuan Trung
 */
public class BookSet implements EntitySet {

    ArrayList<Book> list = new ArrayList<>();
//===================================================================================================================  

    public BookSet() {
        Connection con = DatabaseUser.getConnection();
        String query = "select * from library.book";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getString(1));
                b.setIsbn(rs.getString(2));
                b.setTitle(rs.getString(3));
                b.setAuthor(rs.getString(4));
                b.setYear_of_pub(rs.getString(5));
                b.setDowload_link(rs.getString(6));
                b.setAdd_date(rs.getString(7));
                b.setIs_delete(rs.getString(8));
                b.setLast_modified_at(rs.getString(9));
                b.setSummary(rs.getString(10));
                list.add(b);
            }
        } catch (Exception e) {
            System.out.println("Error in BookSet constructor");
        }
    }
//===================================================================================================================

    @Override
    public String getType() {
        return "book";
    }

    @Override
    public Entity getEntity(String id) {
        for (Book x : list) {
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
        String sql = "insert into library.book "
                + "(ISBN, title, author, year_of_pub, summary, download_link)"
                + " values(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            Book b = (Book) newE;
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getIsbn());
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getAuthor());
            ps.setString(4, b.getYear_of_pub());
            ps.setString(5, b.getSummary());
            ps.setString(6, b.getDowload_link());
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
