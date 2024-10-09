package org.example.stage1;

public class ArrayStack<V> implements MyStack<V> {

    V[] stack;

    int top = -1;


    public ArrayStack(int capacity) {
        this.stack = (V[]) new Object[capacity];
    }

    @Override
    public void push(V value) {
        if (top + 1 == stack.length) {
            return;
        }
        stack[++top] = value;
    }

    @Override
    public V pop() {
        if (top == -1) {
            return null;
        }
        V res = stack[top];
        stack[top--] = null;
        return res;
    }
}
