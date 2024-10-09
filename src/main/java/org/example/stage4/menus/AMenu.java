package org.example.stage4.menus;

import org.example.stage4.api.Menu;

public class AMenu extends Menu {

    public AMenu() {
        title = "A";
        items.addAll(SubDigitsMenu.sub());
    }
}
