package org.example;

import static org.example.Main.*;

public class Ispolindrom implements Runnable {

    private final String[] texts;

    public Ispolindrom(String[] texts) {

        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            if (isPolindromSearch(text)) {
                if (text.length() == 3) {
                    atomicInt2.incrementAndGet();
                } else if (text.length() == 4) {
                    atomicInt1.incrementAndGet();
                } else if (text.length() == 5) {
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


}


