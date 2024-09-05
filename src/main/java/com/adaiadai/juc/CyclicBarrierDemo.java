package com.adaiadai.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Thread2 extends Thread {

    private CyclicBarrier cyclicBarrier;

    public Thread2(String name, CyclicBarrier cyclicBarrier) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println(Thread.currentThread() + "barrierAction");
        });

        Thread2 t1 = new Thread2("t1", cyclicBarrier);
        Thread2 t2 = new Thread2("t2", cyclicBarrier);

        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName() + " going to await");
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName() + " continue");
    }
}
