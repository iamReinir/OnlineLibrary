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
public class BookSetStub implements EntitySet {

    BookStub[] list;

    public BookSetStub() {
        list = new BookStub[]{
            new BookStub("0", "HarryPtter", "JK Rolling", "2023",
            "Harry Potter's knock off. Even the author pen name is knocked off."),
            new BookStub("1", "WorldEnd", "idk", "2005",
            "Depressing story about tatical nuclear bomb girls."),
            new BookStub("2", "KonoSuba", "idontremember", "2006",
            "Isekai about a NEET, a terrorism bomber, a water filter and a masochist."),
            new BookStub("3", "reZero", "notSubaru", "2007",
            "Isekai, but the NEET die more than he should be."),
            new BookStub("4", "Mushoku", "theSameDudeWhoWriteOrcStory", "2005",
            "BEHOLD, the grandfather of all trash isekai. Popularized truck-kun.")
        };
    }
    @Override
    public String getType() {
        return "book";
    }

    @Override
    public Entity getEntity(String id) {
        try {
            return list[Integer.parseInt(id)];
        } catch (Exception e) {
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
        return new Entity[]{
            getEntity("0"),
            getEntity("1"),
            getEntity("2"),
            getEntity("3"),
            getEntity("4"),        };
    }

    @Override
    public boolean add(Entity new_entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
