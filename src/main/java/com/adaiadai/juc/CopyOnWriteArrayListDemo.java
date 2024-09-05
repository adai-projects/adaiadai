package com.adaiadai.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class PutThread extends Thread {
    private final CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

    public PutThread(CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    public void run() {
        try {
            for (int i = 100; i < 110; i++) {
                copyOnWriteArrayList.add(i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i);
        }

        PutThread p1 = new PutThread(copyOnWriteArrayList);
        p1.start();
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}