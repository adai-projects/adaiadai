package com.adaiadai.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTimeoutDemo {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        /*new Thread(ReentrantLockDemo::atm, "线程A").start();
        new Thread(ReentrantLockDemo::atm, "线程B").start();
        new Thread(ReentrantLockDemo::atm, "线程C").start();*/

        for (int i = 0; i < 10; i++) {
            new Thread(TryLockWithTimeoutDemo::atm, "线程" + i).start();
        }

    }

    public static void atm() {
        boolean b;
        try {
            b = lock.tryLock(10, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (b) {
            System.out.println(Thread.currentThread() + "进入ATM，正在取钱");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
//        System.out.println(Thread.currentThread().getName() + "退出ATM");
        } else {
            System.out.println(Thread.currentThread() + "Cant obtain lock");
        }
    }


}


