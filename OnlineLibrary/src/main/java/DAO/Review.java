/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Giga P34
 */
public class Review {
    String id;
    String book_id;
    String user_id;
    String username;
    double rating;
    String review;
    boolean is_delete;
    String review_date;

    public Review() {
    }

    public Review(Entity x) {
        this.book_id = x.getAttribute("id");
        this.book_id = x.getAttribute("book_id");
        this.user_id = x.getAttribute("user_id");
        this.rating = Double.parseDouble(x.getAttribute("rating"));
        this.review = x.getAttribute("user_review");
        this.review_date = x.getAttribute("review_date");
        this.is_delete = x.isDeleted();
        this.username = EntityFactory.getEntitySet("user")
                .searchResult(user -> {
            return user.getAttribute("id").equals(user_id);
                })[0].getAttribute("username");
    }

    public Review(String id, String book_id, String user_id, double rating, String review, boolean is_delete, String review_date) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.rating = rating;
        this.review = review;
        this.is_delete = is_delete;
        this.review_date = review_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    public static ArrayList<Review> allReview(boolean non_deleted) {
        ArrayList<Review> x = new ArrayList<>();
        Entity[] all = EntityFactory.getEntitySet("review").all();
        for (Entity e : all) {
            if (non_deleted && e.isDeleted()) {
                continue;
            }
            Review rv = new Review(e);
            x.add(rv);
        }
        return x;
    }

    public static ArrayList<Review> allReviewOfBook(String id, boolean non_deleted) {
        ArrayList<Review> x = new ArrayList<>();
        Entity[] all = EntityFactory.getEntitySet("review").all();
        for (Entity e : all) {
            if (non_deleted && e.isDeleted() || !e.getAttribute("book_id").equals(id)) {
                continue;
            }
            Review rv = new Review(e);
            x.add(rv);
        }
        return x;
    }
}
