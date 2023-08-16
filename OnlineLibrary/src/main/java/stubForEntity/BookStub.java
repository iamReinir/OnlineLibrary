/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stubForEntity;

import model_interface.Entity;

/**
 *
 * @author Giga P34
 */
public class BookStub implements Entity {

    public String id;
    public String title;
    public String author;
    public String year;
    public String summary;

    public BookStub(String id, String title, String author, String year, String summary) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.summary = summary;
    }

    @Override
    public String getType() {
        return "book";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id", "title", "author"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "title":
                return title;
            case "author":
                return author;
            case "year_of_pub":
                return year;
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
            case "title":
                title = value;
                break;
            case "author":
                author = value;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean setAttributes(String[] attribute_names, String[] values) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    @Override
    public boolean delete(boolean is_delete) {
        return false;
    }

}
