package org.example.stage3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesCheckerTest {

    @Test
    void check() {
        assertTrue(ParenthesesChecker.check("{(<[ ]>)}"));
        assertTrue(ParenthesesChecker.check("{{}}(())[[]]<<>>"));

        assertFalse(ParenthesesChecker.check("{(<[ "));
        assertFalse(ParenthesesChecker.check("]>)}"));
        assertFalse(ParenthesesChecker.check("))"));
        assertFalse(ParenthesesChecker.check("}"));
        assertFalse(ParenthesesChecker.check("]"));
    }
}