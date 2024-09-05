package com.adaiadai.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithFairDemo {

    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        Runnable runnable = () -> {
            lock.lock();
            System.out.println(Thread.currentThread() + "locked");
            try {
                System.out.println(Thread.currentThread());
            } finally {
                lock.unlock();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

}
