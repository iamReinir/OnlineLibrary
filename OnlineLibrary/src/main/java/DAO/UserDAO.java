package DAO;

import java.util.function.Predicate;
import model_interface.Entity;
import model_interface.EntityFactory;
import model_interface.EntitySet;

/**
 *
 * @author Nguyen Xuan Trung Class for integration
 */
public class UserDAO {

    public String user_id;
    public String username;
    public String role;

    private UserDAO() {
    }

    private UserDAO(String username, String password) {
        //This is for testing
//        if (username != null && password != null
//                && username.equals("reinir") && password.equals("reinir")) {
//            this.user_id = "0";
//            this.username = "reinir";
//            this.role = "reader";
//            return;
//        }
        //End of testing block
        EntitySet users = EntityFactory.getEntitySet("user");
        Predicate<Entity> check_username_password = (user) -> {
            boolean username_check = user.getAttribute("username").equals(username);
            boolean password_check = user.getAttribute("password").equals(password);
            return username_check && password_check;
        };
        Entity[] result = users.searchResult(check_username_password);
        if (result.length < 1) {
            this.user_id = null;
            this.username = null;
            this.role = null;
        } else {
            this.user_id = result[0].getAttribute("user_id");
            this.username = result[0].getAttribute("username");
            this.role = result[0].getAttribute("role");
        }
    }

    public static UserDAO login(String username, String password) {
        UserDAO u = new UserDAO();
        //This is for testing
//        if (username != null && password != null
//                && username.equals("reinir") && password.equals("reinir")) {
//            u.user_id = "0";
//            u.username = "reinir";
//            u.role = "reader";
//            return u;
//        }
        //End of testing block
        EntitySet users = EntityFactory.getEntitySet("user");
        Predicate<Entity> check_username_password = (user) -> {
            boolean username_check = user.getAttribute("username").equals(username);
            boolean password_check = user.getAttribute("password").equals(password);
            return username_check && password_check;
        };
        Entity[] result = users.searchResult(check_username_password);
        if (result.length < 1) {
            return null;
        } else {
            u.user_id = result[0].getAttribute("id");
            u.username = result[0].getAttribute("username");
            u.role = result[0].getAttribute("role");
        }
        return u;
    }

    public static boolean isExist(String username) {
        EntitySet users = EntityFactory.getEntitySet("user");
        Predicate<Entity> check_username = (user) -> {
            boolean username_check = user.getAttribute("username").equals(username);
            return username_check;
        };
        Entity[] result = users.searchResult(check_username);
        if (result.length < 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean signup(String username, String password, String email, String role) {
        EntitySet users = EntityFactory.getEntitySet("user");
        Entity newUser = EntityFactory.createEntity("user");
        newUser.setAttribute("username", username);
        newUser.setAttribute("password", password);
        newUser.setAttribute("email", email);
        newUser.setAttribute("role", role);
        return users.add(newUser);
    }
}
