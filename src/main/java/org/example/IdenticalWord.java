package org.example;

import static org.example.Main.*;

public class IdenticalWord implements Runnable {
    private final String[] texts;

    public IdenticalWord(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts)
            if (isIdenticalWord(text)) {
                if (text.length() == 3) {
                    atomicInt2.incrementAndGet();
                } else if (text.length() == 4) {
                    atomicInt1.incrementAndGet();
                } else if (text.length() == 5) {
                    atomicInt3.incrementAndGet();
                }
            }
    }

    public static boolean isIdenticalWord(String text) {
        return text != null && !text.isEmpty() && text.chars().allMatch(c -> text.charAt(0) == c);

    }
}
