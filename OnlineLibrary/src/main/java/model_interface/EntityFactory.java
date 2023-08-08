package model_interface;

import stubForEntity.BookSetStub;

/**
 * Static class to create Entity and EntitySet
 */
public class EntityFactory {
    public static String[] getEntityTypeName() {
        //TODO : Huy viết cái này
        return null;
    }

    public static EntitySet getEntitySet(String entity_type) {
        return new BookSetStub();
        //TODO : Huy viết cái này        
    }

    static Entity createEntity(String entity_type) {
        //TODO : Huy viết cái này
        return null;
    }
}
