/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Book {
    private int id;
    private String ISBN;
    private String title;
    private String author;
    private int year_of_pub;
    private String download_link;
    private String add_date;
    private boolean is_delete;
    private String last_modified_at;
    private String summary;

    public Book() {
    }

    public Book(int id, String ISBN, String title, String author, int year_of_pub, String download_link, String add_date, boolean is_delete, String last_modified_at, String summary) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year_of_pub = year_of_pub;
        this.download_link = download_link;
        this.add_date = add_date;
        this.is_delete = is_delete;
        this.last_modified_at = last_modified_at;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getYear_of_pub() {
        return year_of_pub;
    }

    public void setYear_of_pub(int year_of_pub) {
        this.year_of_pub = year_of_pub;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(String last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    
}
