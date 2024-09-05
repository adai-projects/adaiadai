package com.adaiadai.juc;

import java.util.concurrent.CountDownLatch;

class Thread1 extends Thread {
    private final CountDownLatch countDownLatch;

    public Thread1(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " doing something");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish");
        // 此函数将递减锁存器的计数，如果计数到达零，则释放所有等待的线程
        countDownLatch.countDown();
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread1 t1 = new Thread1("t1", countDownLatch);
        Thread1 t2 = new Thread1("t2", countDownLatch);
        t1.start();
        t2.start();
        System.out.println("Waiting for t1 thread and t2 thread to finish");
        try {
            // 此函数将会使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " continue");
    }
}