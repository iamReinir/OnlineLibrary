/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;
import model_interface.Entity;

/**
 *
 * @author Lenovo
 */
public class Book {
    private String id;
    private String ISBN;
    private String title;
    private String author;
    private String year_of_pub;
    private String download_link;
    private boolean is_delete;
    private String summary;
    public Book() {
    }

    public Book(Entity book) {
        if (book.getType().equals("book") == false) {
            throw new RuntimeException("not a book");
        }
        this.setId(book.getAttribute("id"));
        this.setTitle(book.getAttribute("title"));
        this.setAuthor(book.getAttribute("author"));
        this.setDownload_link(book.getAttribute("download_link"));
        this.setISBN(book.getAttribute("isbn"));
        this.setSummary(book.getAttribute("summary"));
        this.setYear_of_pub(book.getAttribute("year_of_pub"));
        this.setIs_delete(book.isDeleted());
    }


    public Book(String id, String ISBN, String title, String author, String year_of_pub, String download_link, boolean is_delete, String summary) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year_of_pub = year_of_pub;
        this.download_link = download_link;
        this.is_delete = is_delete;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear_of_pub() {
        return year_of_pub;
    }

    public void setYear_of_pub(String year_of_pub) {
        this.year_of_pub = year_of_pub;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
        if (download_link != null && download_link.equals("null")) {
            download_link = null;
        }
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    
}
