package org.example.stage1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ArrayStackTest {

    MyStack<String> stack = new ArrayStack<>(10);
    @Test
    void push() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertEquals("three", stack.pop());
        assertEquals("two", stack.pop());
        assertEquals("one", stack.pop());
        assertNull(stack.pop());
    }
}