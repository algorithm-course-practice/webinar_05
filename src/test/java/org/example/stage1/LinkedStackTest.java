package org.example.stage1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    MyStack<String> stack = new LinkedStack<>();
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