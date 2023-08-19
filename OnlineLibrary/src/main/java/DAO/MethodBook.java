package DAO;

import model_interface.*;

/**
 *
 * @author Nguyen Thuy - edit Nguyen Xuan Trung
 */
public class MethodBook {
    public MethodBook() {
    }

    // return true if add success;
    public static boolean Addbook(
            String isbn,
            String Title,
            String Author,
            String Year,
            String Summary,
            String download_link) {
        Entity book = EntityFactory.createEntity("book");
        book.setAttribute("isbn", isbn);
        book.setAttribute("title", Title);
        book.setAttribute("author", Author);
        book.setAttribute("year_of_pub", Year);
        book.setAttribute("summary", Summary);
        book.setAttribute("download_link", download_link);
        return EntityFactory.getEntitySet("book").add(book);
    }

    public void AccBook(boolean Acc, String Id) {
        if (Acc) {
//            BookSetStub book =new BookSetStub();
//            book.getEntity(Id).setAttribute(isaccept, true);
            //bên em có trường isaccept bên chị ko nên lỗi chỗ ni nên em bỏ vào sẽ chạy đc

        }

    }
}
