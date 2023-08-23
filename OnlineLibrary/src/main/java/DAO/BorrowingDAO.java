package DAO;

import java.util.ArrayList;
import java.util.List;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Huynh Thai Duong - edit Nguyen Xuan Trung
 */
public class BorrowingDAO {

    public List<Borrowing> getAllBorrowingBookByBorrowerID(int id) {
        List<Borrowing> list = new ArrayList<>();
        Entity[] borrowing = EntityFactory.getEntitySet("borrowing").searchResult(br -> {
            return br.getAttribute("borrower_id").equals(String.valueOf(id))
                    && br.getAttribute("return_date") == null;
        });
        for (Entity e : borrowing) {
            list.add(new Borrowing(
                    e.getAttribute("id"),
                    e.getAttribute("borrower_id"),
                    e.getAttribute("borrowed_book"),
                    e.getAttribute("start_date"),
                    e.getAttribute("due_date"),
                    e.getAttribute("return_date"),
                    e.getAttribute("last_modified_at"),
                    e.isDeleted()
            ));
        }
        return list;
    }
    public List<Borrowing> getAllBorrowedBookByBorrowerID(int id) {
        List<Borrowing> list = new ArrayList<>();
        Entity[] borrowing = EntityFactory.getEntitySet("borrowing").searchResult(br -> {
            return br.getAttribute("borrower_id").equals(String.valueOf(id))
                    && br.getAttribute("return_date") != null;
        });
        for (Entity e : borrowing) {
            list.add(new Borrowing(
                    e.getAttribute("id"),
                    e.getAttribute("borrower_id"),
                    e.getAttribute("borrowed_book"),
                    e.getAttribute("start_date"),
                    e.getAttribute("due_date"),
                    e.getAttribute("return_date"),
                    e.getAttribute("last_modified_at"),
                    e.isDeleted()
            ));
        }
        return list;
    }

    public static boolean isAvailable(String book_id) {
        return EntityFactory.getEntitySet("borrowing").searchResult(br -> {
            return br.getAttribute("borrowed_book").equals(book_id)
                    && br.isDeleted() == false;
        }).length == 0;
    }

    public static boolean isBorrowing(String book_id, String user_id) {
        return EntityFactory.getEntitySet("borrowing").searchResult(br -> {
            return br.getAttribute("borrowed_book").equals(book_id)
                    && br.getAttribute("borrower_id").equals(user_id)
                    && br.isDeleted() == false;
        }).length != 0;
    }
}
