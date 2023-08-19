package modelSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.User;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Ho Quoc Huy - edit: Nguyen Xuan Trung
 */
public class UserSet implements EntitySet {

    ArrayList<User> list = new ArrayList<>();

    public UserSet() {
        Connection con = DatabaseUser.getConnection();
        String query = "select * from library.user";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString("id_user"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setTelephone_number(rs.getString("telephone_number"));
                u.setRole(rs.getString("role"));
                u.setIs_delete(rs.getString("is_delete").equals("1") ? "true" : "false");
                u.setRegister_date(rs.getString("register_date"));
                u.setLast_modified_at(rs.getString("last_modified_at"));
                list.add(u);
            }

        } catch (Exception e) {
            System.out.println("UserSet init error");
        }
    }
//===================================================================================================================

    @Override
    public String getType() {
        return "user";
    }

    @Override
    public Entity getEntity(String id) {
        try {
            for (User x : list) {
                if (x.getId().equals(id)) {
                    return x;
                }
            }
        } catch (Exception e) {
            System.out.println("I dont think this can happen");
        }
        return null;
    }

    @Override
    public Entity[] all() {
        Entity[] res = new Entity[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Override
    public boolean add(Entity newE) {
        Connection con = DatabaseUser.getConnection();
        String sql = "insert into library.user "
                + "(username, password, email,telephone_number,role)"
                + "values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            User u = (User) newE;
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getTelephone_number());
            ps.setString(5, u.getRole());
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
