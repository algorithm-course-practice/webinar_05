package org.example.stage4;

import org.example.stage1.LinkedStack;
import org.example.stage1.MyStack;
import org.example.stage4.api.Action;
import org.example.stage4.api.Menu;
import org.example.stage4.api.MenuItem;
import org.example.stage4.menus.MainMenu;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class MenuNavigation {

    public static void main(String[] args) {
        MyStack<Menu> stack = new LinkedStack<>();
        stack.push(new MainMenu());

        Menu current = null;
        Scanner scanner = new Scanner(System.in);
        while ((current = stack.pop()) != null) {
            System.out.println("Current menu: " + current.getTitle());
            printItems(current);

            System.out.println("Choose action: ");
            int action = scanner.nextInt() - 1;
            if (action > -1 && action < current.getItems().size()) {
                BiConsumer<MyStack<Menu>, Menu> nextAction = current.getItems().get(action).getAction();
                Action.retry().andThen(nextAction).accept(stack, current);
            } else {
                System.out.println("Invalid action, choose right number!");
                stack.push(current);
            }
        }

    }

    private static void printItems(Menu current) {
        for (int i = 0; i < current.getItems().size(); i++) {
            MenuItem menuItem = current.getItems().get(i);
            System.out.printf("%d) %s%n", i+1, menuItem.getLabel());
        }
    }

}

