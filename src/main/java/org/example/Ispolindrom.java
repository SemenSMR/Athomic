package org.example;

import static org.example.Main.*;

public class Ispolindrom implements Runnable {

    private final String[] texts;

    public Ispolindrom( String[] texts) {

        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            if (isPolindromSearch(text)) {
                if (text.length() == 3) {
                    atomicInt1.incrementAndGet();
                }
            }
            if (isIdenticalWord(text)) {
                if (text.length() == 4) {
                    atomicInt2.incrementAndGet();
                }
            }
            if (isWordOrder(text)) {
                if (text.length() == 5) {
                    atomicInt3.incrementAndGet();

                }
            }
        }
    }

    public static boolean isPolindromSearch(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        char firstChar = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != firstChar) {
                return true;
            }
        }
        return false;

    }


    public static boolean isIdenticalWord(String text) {
        return text != null && !text.isEmpty() && text.chars().allMatch(c -> text.charAt(0) == c);

    }

    public static boolean isWordOrder(String text) {
        char oneChar = text.charAt(0);
        char count = 1;
        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == oneChar) {
                count++;
            } else {
                if (currentChar != oneChar + 1) {
                    return false;
                }
                count = 1;
            }
            if (count > 2) {
                return false;
            }
            oneChar = currentChar;
        }
        return true;
    }
}


