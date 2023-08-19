package model_interface;

import model.*;
import modelSet.*;

/**
 * Static class to create Entity and EntitySet
 *
 * @author Nguyen Xuan Trung
 */
public class EntityFactory {

    public static String[] getEntityTypeName() {
        return new String[]{
            "book",
            "borrowing",
            "renewal",
            "reservation",
            "user",
            "review"
        };
    }

    public static EntitySet getEntitySet(String entity_type) {
        switch (entity_type) {
            case "book":
                return new BookSet();
            case "review":
                return new ReviewSet();
            case "borrowing":
                return new BorrowingSet();
            case "renewal":
                return new RenewalSet();
            case "reservation":
                return new ReservationSet();
            case "user":
                return new UserSet();
            default:
                return null;
        }
    }

    public static Entity createEntity(String entity_type) {
        switch (entity_type) {
            case "book":
                return new Book();
            case "review":
                return new Review();
            case "borrowing":
                return new Borrowing();
            case "renewal":
                return new Renewal();
            case "reservation":
                return new Reservate();
            case "user":
                return new User();
            default:
                return null;
        }
    }
}
