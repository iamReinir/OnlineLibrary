package model_interface;


import model_interface.Entity;
import java.util.function.Predicate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public interface EntitySet {
    String getType();
    Entity getEntity(String id);
    Entity[] searchResult(String attribute, Predicate<String> search_function);
    Entity[] all();
    //boolean add(Entity new_entity);
}
