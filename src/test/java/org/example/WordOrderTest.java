package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordOrderTest {

    @Test
  public void testValidOrderWord() {
       assertTrue(WordOrder.isWordOrder("bbcc"));
       assertTrue(WordOrder.isWordOrder("aabbc"));
       assertTrue(WordOrder.isWordOrder("ab"));
    }

    @Test
    public void testInvalidOrderedWord(){
        assertFalse(WordOrder.isWordOrder("acb"));
        assertFalse(WordOrder.isWordOrder("bac"));
        assertFalse(WordOrder.isWordOrder("cab"));
        assertFalse(WordOrder.isWordOrder("cba"));
    }
}