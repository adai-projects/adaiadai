package com.adaiadai.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo implements Runnable {
    private final static Lock LOCK = new ReentrantLock();

    @Override
    public void run() {
        try {
            go();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    private void go() throws InterruptedException {
        LOCK.lockInterruptibly();
        try {
            while (true) {

            }
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockInterruptiblyDemo demo = new LockInterruptiblyDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t2.interrupt();
        //等待1秒，让 t2.interrupt(); 执行生效
        TimeUnit.SECONDS.sleep(1);
        System.out.println("线程t1是否存活：" + t1.isAlive());
        System.out.println("线程t2是否存活：" + t2.isAlive());
    }

}


