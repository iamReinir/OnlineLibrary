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
                b.setId(rs.getString("id_BOOK"));
                b.setIsbn(rs.getString("ISBN"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setYear_of_pub(rs.getString("year_of_pub"));
                b.setDownload_link(rs.getString("download_link"));
                b.setAdd_date(rs.getString("add_date"));
                b.setIs_delete(rs.getString("is_delete").equals("1") ? "true" : "false");
                b.setLast_modified_at(rs.getString("last_modified_at"));
                b.setSummary(rs.getString("summary"));
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
            ps.setString(6, b.getDownload_link());
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
