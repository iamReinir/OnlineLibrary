/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model_interface.Entity;

/**
 *
 * @author PC
 */
public class book implements Entity{
    public String id;
    public String isbn;
    public String title;
    public String author;
    public String year_of_pub;
    public String dowload_link;
    public String add_date;
    public String is_delete = "false";
    public String last_modified_at;
    public String summary;

    public book() {
    }

    public book(String id, String isbn, String title, String author, String year_of_pub, 
            String dowload_link, String add_date, String is_delete, String last_modified_at, String summary) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year_of_pub = year_of_pub;
        this.dowload_link = dowload_link;
        this.add_date = add_date;
        this.is_delete = is_delete;
        this.last_modified_at = last_modified_at;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getDowload_link() {
        return dowload_link;
    }

    public void setDowload_link(String dowload_link) {
        this.dowload_link = dowload_link;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
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
    
    
    
    @Override
    public String getType() {
        return "book";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id",
            "ISBN",
            "title",
            "author",
            "year_of_pub",
            "dowload_link",
            "add_date",
            "is_delete",
            "last_modified_at",
            "summary"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "isbn":
                return isbn;
            case "title":
                return title;
            case "author":
                return author;
            case "year_of_pub":
                return year_of_pub;
            case "dowload_link":
                return dowload_link;
            case "add_date":
                return add_date;
            case "is_delete":
                return is_delete;
            case "last_modified_at":
                return last_modified_at;
            case "summary":
                return summary;
            default:
                return "------ I’m sorry but I’m not sure what you’re asking for. "
                        + "Could you please clarify your request? "
                        + "If you’re looking for a summary of a book, "
                        + "I suggest you provide me with the title "
                        + "and author of the book so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "isbn":
                isbn = value;
                break;
            case "title":
                title = value;
                break;
            case "author":
                author = value;
                break;
            case "year_of_pub":
               year_of_pub = value;
               break;
            case "dowload_link":
                dowload_link = value;
                break;
            case "add_date":
                add_date = value;
                break;
            case "is_delete":
                is_delete = value;
                break;
            case "last_modified_at":
                last_modified_at = value;
                break;
            case "summary":
                summary = value;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean setAttributes(String[] attribute_names, String[] values) {
        if(attribute_names.length == values.length){
            for(int i = 0; i <= attribute_names.length; i++){
                attribute_names[i] = values[i];
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete() {
        this.is_delete = "true";
        return true;
    }

    @Override
    public boolean undelete() {
        this.is_delete = "false";
        return false;
    }  
}
