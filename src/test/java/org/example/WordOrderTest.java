package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordOrderTest {

    @Test
  public void testValidOrderWord() {
       assertTrue(Ispolindrom.isWordOrder("bbcc"));
       assertTrue(Ispolindrom.isWordOrder("aabbc"));
       assertTrue(Ispolindrom.isWordOrder("abbcc"));
    }

    @Test
    public void testInvalidOrderedWord(){
        assertFalse(Ispolindrom.isWordOrder("acb"));
        assertFalse(Ispolindrom.isWordOrder("bac"));
        assertFalse(Ispolindrom.isWordOrder("cab"));
        assertFalse(Ispolindrom.isWordOrder("cba"));
    }
}