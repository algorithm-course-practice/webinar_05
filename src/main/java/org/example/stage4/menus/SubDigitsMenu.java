package org.example.stage4.menus;

import org.example.stage4.api.Action;
import org.example.stage4.api.Menu;
import org.example.stage4.api.MenuItem;

import java.util.List;

import static java.util.Arrays.asList;

public class SubDigitsMenu extends Menu {

    public static List<MenuItem> sub() {
        return asList(
                new MenuItem("1", (s,c)-> System.out.println("Selected ONE")),
                new MenuItem("2", (s,c)-> System.out.println("Selected TWO")),
                new MenuItem("3", (s,c)-> System.out.println("Selected THREE")),
                new MenuItem("Back", Action.back())
        );
    }
}
