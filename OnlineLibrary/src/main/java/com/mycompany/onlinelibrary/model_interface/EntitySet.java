package com.mycompany.onlinelibrary.model_interface;

import java.util.function.Predicate;

/**
 * An interface represent the set of Entity. EntityFactory should be used when
 * an instance of EntitySet is needed.
 *
 * @author Nguyen Xuan Trung
 */
public interface EntitySet {

    /**
     *
     * @return the name of the table.
     */
    String getType();

    /**
     *
     * @param id : id of the entity
     * @return the Entity with the specified id
     */
    Entity getEntity(String id);

    /**
     *
     * @param search_function : A function to search.
     * @return Array of Entity that search_function return true
     */
    Entity[] searchResult(Predicate<Entity> search_function);

    /**
     *
     * @return everything in the table
     */
    Entity[] all();

    /**
     *
     * @param new_entity : Entity to add to the table
     * @return True if add success, False if the Entity format is wrong.
     */
    boolean add(Entity new_entity);
}
