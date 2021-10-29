package com.neginet.processdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LineValidationTest {
    @Test
    public void matchFindPatternTest() {
        String matcher = LineValidation.getFirstAndLastName("thiago, ferreira --");

        assertEquals("thiago, ferreira ", matcher);
    }

    @Test
    public void matchDisconsiderNumberOnPatternTest() {
        String matcher = LineValidation.getFirstAndLastName("thiago1, ferreira --");

        assertEquals(null, matcher);
    }
    @Test
    public void matchDisconsiderCharacterOnPatternTest() {
        String matcher = LineValidation.getFirstAndLastName("thiago,, ferreira --");

        assertEquals(null, matcher);
    }
}
