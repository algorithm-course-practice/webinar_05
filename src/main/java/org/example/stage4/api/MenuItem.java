package org.example.stage4.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.stage1.MyStack;

import java.util.function.BiConsumer;

@AllArgsConstructor
@Getter
public class MenuItem {

    final String label;

    final BiConsumer<MyStack<Menu>, Menu> action;

}
