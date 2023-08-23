package DAO;

import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Huynh Thai Duong
 */
public class BookDAO {

    public static Book getBookByID(int id) {
        Entity book = EntityFactory.getEntitySet("book").getEntity(String.valueOf(id));
        Book result = new Book(book);
        return result;
    }
}
