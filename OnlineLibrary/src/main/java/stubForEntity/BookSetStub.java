/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stubForEntity;

import java.util.function.Predicate;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Giga P34
 */
public class BookSetStub implements EntitySet {

    @Override
    public String getType() {
        return "book";
    }

    @Override
    public Entity getEntity(String id) {
        return new BookStub(id, "title for " + id, "author for " + id);
    }

    @Override
    public Entity[] searchResult(Predicate<Entity> search_function) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Entity[] all() {
        return new Entity[]{
            getEntity("1"),
            getEntity("2"),
            getEntity("3"),
            getEntity("4"),
            getEntity("5"),
            getEntity("6")
        };
    }

    @Override
    public boolean add(Entity new_entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}