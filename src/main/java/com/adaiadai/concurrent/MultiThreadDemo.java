package com.adaiadai.concurrent;

public class MultiThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B");
            }
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }

}
