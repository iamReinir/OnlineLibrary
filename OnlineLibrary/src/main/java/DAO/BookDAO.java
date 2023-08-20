package DAO;

import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Huynh Thai Duong
 */
public class BookDAO {

    public Book getBookByID(int id) {
        Entity book = EntityFactory.getEntitySet("book").getEntity(String.valueOf(id));
        Book result = new Book(
                Integer.parseInt(book.getAttribute("id")),
                book.getAttribute("isbn"),
                book.getAttribute("title"),
                book.getAttribute("author"),
                Integer.parseInt(book.getAttribute("year_of_pub")),
                book.getAttribute("download_link"),
                book.getAttribute("add_date"),
                book.isDeleted(),
                book.getAttribute("last_modified_at"),
                book.getAttribute("summary")
        );
        return result;
    }
}
