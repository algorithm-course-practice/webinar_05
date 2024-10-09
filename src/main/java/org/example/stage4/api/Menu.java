package org.example.stage4.api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Menu {
    protected String title = "Menu title";
    protected List<MenuItem> items = new ArrayList<>();
}
