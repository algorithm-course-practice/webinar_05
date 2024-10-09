package org.example.stage2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraverseTest {

    @Test
    void findSubString() {
        TreeTraverse traverse = new TreeTraverse();

        TreeTraverse.Node root = new TreeTraverse.Node("abc");
        root.setLeft(new TreeTraverse.Node("bzx"));
        root.setRight(new TreeTraverse.Node("ckl"));

        assertNull(traverse.findSubString(root, "f"));
        assertEquals("abc", traverse.findSubString(root, "a"));
        assertEquals("bzx", traverse.findSubString(root, "z"));
        assertEquals("ckl", traverse.findSubString(root, "k"));
    }
}