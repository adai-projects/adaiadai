package com.adaiadai.juc;

public class SynchronizedObjectLock1 implements Runnable {

    static SynchronizedObjectLock1 instance = new SynchronizedObjectLock1();

    @Override
    public void run() {
        synchronized (this) {
            // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
            System.out.println(Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "end");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }

}
