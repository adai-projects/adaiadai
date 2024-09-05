package com.adaiadai.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithFairDemo1 {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock(false);

        ThreadDemo t1 = new ThreadDemo("t1", lock);
        ThreadDemo t2 = new ThreadDemo("t2", lock);
        ThreadDemo t3 = new ThreadDemo("t3", lock);
        t1.start();
        t2.start();
        t3.start();
    }

}

class ThreadDemo extends Thread {

    private final Lock lock;

    public ThreadDemo(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
