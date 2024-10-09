package org.example.stage5;

import org.junit.jupiter.api.Test;

import static org.example.stage5.ShuntingYardAlgorithm.translate;
import static org.junit.jupiter.api.Assertions.*;

class ShuntingYardAlgorithmTest {

    /**
     *  пример онлайн https://jsfiddle.net/7jh9f/2/
     */

    @Test
    void check() {
        assertEquals("2 3 4 * +", translate("2 + 3 * 4"));
        assertEquals("1 2 + 3 -", translate("1 + 2 - 3"));
        assertEquals("2 3 + 4 *", translate("( ( 2 + 3 ) ) * 4"));
        assertEquals("2 3 4 * + 5 - 7 6 * 3 / + 2 3 2 ^ * - 5 2 - 2 * +", translate("2 + 3 * 4 - 5 + 7 * 6 / 3 - 2 * 3 ^ 2 + ( 5 - 2 ) * 2"));
        assertThrows(IllegalArgumentException.class,() -> translate("( 2 + 3 ) ) * 4"));
    }
}