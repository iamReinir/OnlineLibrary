/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Lenovo
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
                new Date(Date.parse(book.getAttribute("add_date"))),
                book.getAttribute("is_delete").equals("true"),
                new Date(Date.parse(book.getAttribute("last_modified_at"))),
                book.getAttribute("summary")
        );
        return result;
    }
}
