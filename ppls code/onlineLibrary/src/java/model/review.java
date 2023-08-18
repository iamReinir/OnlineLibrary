/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model_interface.Entity;

/**
 *
 * @author PC
 */
public class review implements Entity{
    public String id;
    public String user_id;
    public String book_id;
    public String rating;
    public String user_review;
    public String review_date;
    public String is_delete = "false";
    public String last_modified_at;

    public review() {
    }

    public review(String id, String user_id, String book_id, String rating, 
            String user_review, String review_date, String last_modified_at) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.rating = rating;
        this.user_review = user_review;
        this.review_date = review_date;
        this.last_modified_at = last_modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUser_review() {
        return user_review;
    }

    public void setUser_review(String user_review) {
        this.user_review = user_review;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
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
    
    
    @Override
    public String getType() {
        return "review";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id",
            "user_id",
            "book_id",
            "rating",
            "user_review",
            "review_date",
            "is_delete",
            "last_modified_at"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "user_id":
                return user_id;
            case "book_id":
                return book_id;
            case "rating":
                return rating;
            case "user_review":
                return user_review;
            case "review_date":
                return review_date;
            case "is_delete":
                return is_delete;
            case "last_modified_at":
                return last_modified_at;
            default:
                return "------ I’m sorry but I’m not sure what you’re asking for. "
                        + "Could you please clarify your request? "
                        + "If you’re looking for a summary of a user, "
                        + "I suggest you provide me with the id, user_id and book id "
                        + "so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "user_id":
                user_id = value;
                break;
            case "book_id":
                book_id = value;
                break;
            case "rating":
                rating = value;
                break;
            case "user_review":
                user_review = value;
               break;
            case "review_date":
                review_date = value;
                break;
            case "is_delete":
                is_delete = value;
                break;
            case "last_modified_at":
                last_modified_at = value;
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
        is_delete = "true";
        return true;
    }

    @Override
    public boolean undelete() {
        is_delete = "false";
        return false;
    }
}
