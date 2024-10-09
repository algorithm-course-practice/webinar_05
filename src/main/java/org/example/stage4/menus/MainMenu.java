package org.example.stage4.menus;

import org.example.stage4.api.Action;
import org.example.stage4.api.Menu;
import org.example.stage4.api.MenuItem;

public class MainMenu extends Menu {

    public MainMenu() {
        title = "Main menu";
        items.add(new MenuItem("a", Action.go(new AMenu())));
//        items.add(new MenuItem("b", Action.go(new BMenu())));
//        items.add(new MenuItem("c", Action.go(new CMenu())));
        items.add(new MenuItem("exit", Action.back()));
    }
}
