package org.example.stage4.api;

import org.example.stage1.MyStack;

import java.util.function.BiConsumer;

public class Action {
    public static BiConsumer<MyStack<Menu>, Menu> go(Menu menu) {
        return (stack, current) -> stack.push(menu);
    }

    public static BiConsumer<MyStack<Menu>, Menu> retry() {
        return (stack, current) -> stack.push(current);
    }


    public static BiConsumer<MyStack<Menu>, Menu> back() {
        return (stack, current) -> stack.pop();
    }


}
