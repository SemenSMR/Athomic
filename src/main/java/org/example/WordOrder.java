package org.example;


import static org.example.Main.atomicInt3;

public class WordOrder implements Runnable {
    private final String[] texts;

    public WordOrder(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts)
            if (isWordOrder(text)) {
                if (text.length() == 5) {
                    atomicInt3.incrementAndGet();

                }
            }
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
