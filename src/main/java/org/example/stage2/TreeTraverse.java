package org.example.stage2;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.stage1.LinkedStack;
import org.example.stage1.MyStack;

import java.util.HashSet;
import java.util.Set;

public class TreeTraverse {


    String findSubString(Node root, String subString) {
        MyStack<Node> stack = new LinkedStack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        Node current = null;
        while ((current = stack.pop()) != null) {
            if (visited.contains(current) && current.right != null) {
                stack.push(current.right);
            } else {
                if (current.label.contains(subString)) {
                    return current.label;
                }
                visited.add(current);
                if(current.left != null || current.right != null){
                    stack.push(current);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        return null;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class Node {
        @NonNull
        String label;

        Node left;

        Node right;

    }
}
