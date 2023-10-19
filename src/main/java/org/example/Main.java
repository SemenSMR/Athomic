package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger atomicInt1 = new AtomicInteger(0);
    public static AtomicInteger atomicInt2 = new AtomicInteger(0);
    public static AtomicInteger atomicInt3 = new AtomicInteger(0);

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        Thread thread3 = new Thread(new Ispolindrom(3, texts));
        Thread thread4 = new Thread(new Ispolindrom(4, texts));
        Thread thread5 = new Thread(new Ispolindrom(5, texts));

        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread3.join();
            thread3.join();
            thread5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Красивых слов с длиной 3: " + atomicInt1.get() + " шт");
        System.out.println("Красивых слов с длиной 4: " + atomicInt2.get() + " шт");
        System.out.println("Красивых слов с длиной 5: " + atomicInt3.get() + " шт");
    }


    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }


}


