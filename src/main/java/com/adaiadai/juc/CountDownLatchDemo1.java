package com.adaiadai.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 */
public class CountDownLatchDemo1 {

    volatile List list = new ArrayList();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    /**
     * 必须先让t2先进行启动 使用wait 和 notify 进行相互通讯，wait会释放锁，notify不会释放锁
     *
     * @param args
     */
    public static void main(String[] args) {

        CountDownLatchDemo1 demo = new CountDownLatchDemo1();
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                if (demo.size() != 5) {
                    try {
                        /**会释放锁*/
                        lock.wait();
                        System.out.println("t2 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 启动");
                for (int i = 0; i < 9; i++) {
                    demo.add(i);
                    System.out.println("add" + i);
                    if (demo.size() == 5) {
                        /**不会释放锁*/
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}