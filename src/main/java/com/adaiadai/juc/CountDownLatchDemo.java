package com.adaiadai.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static class Driver {
        void main() throws InterruptedException {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(3);

            for (int i = 0; i < 3; i++) {
                new Thread(new Worker(startSignal, doneSignal)).start();
            }
            // don't let run yet
            System.out.println("doSomethingElse(1)");
            // let all threads proceed
            startSignal.countDown();
            System.out.println("doSomethingElse(2)");
            // wait for all to finish
            doneSignal.await();
        }
    }

    static class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException ex) {
            }
        }
    }

    static void doWork() {
        System.out.println("working.");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo.Driver driver = new CountDownLatchDemo.Driver();
        driver.main();
    }

}
