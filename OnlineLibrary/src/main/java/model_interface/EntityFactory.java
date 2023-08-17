package model_interface;

import stubForEntity.BookSetStub;
import stubForEntity.ReviewSetStub;

/**
 * Static class to create Entity and EntitySet
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
        if (entity_type.equals("review")) {
            return new ReviewSetStub();
        }
        return new BookSetStub();
        //TODO : Huy viết cái này        
    }

    public static Entity createEntity(String entity_type) {
        //TODO : Huy viết cái này
        return null;
    }
}
