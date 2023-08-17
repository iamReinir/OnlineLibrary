/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stubForEntity;

import java.util.ArrayList;
import java.util.function.Predicate;
import model_interface.Entity;
import model_interface.EntitySet;

/**
 *
 * @author Giga P34
 */
public class ReviewSetStub implements EntitySet {

    Review[] list;

    public ReviewSetStub() {
        list = new Review[]{
            new Review("0", "0", "0", "4", "its ok-ish"),
            new Review("1", "0", "1", "2", "Kinda bad imo"),
            new Review("2", "0", "2", "4", "Not the best, but im enjoying it"),
            new Review("3", "1", "3", "5", "BEST THING EVER"),
            new Review("4", "1", "1", "2", "Not very good"),
            new Review("5", "1", "2", "1", "really suck"),
            new Review("6", "1", "3", "3", "its ok-ish"),};
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Entity getEntity(String id) {
        try {
            return list[Integer.parseInt(id)];
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Entity[] searchResult(Predicate<Entity> search_function) {
        ArrayList<Entity> res = new ArrayList<>();
        Entity[] everything = all();
        for (Entity x : everything) {
            if (search_function.test(x) == true) {
                res.add(x);
            }
        }
        Entity[] ret = new Entity[res.size()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    @Override
    public Entity[] all() {
        return list;
    }

    @Override
    public boolean add(Entity new_entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
