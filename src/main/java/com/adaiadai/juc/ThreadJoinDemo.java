package com.adaiadai.juc;


public class ThreadJoinDemo {

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ThreadA");
        }
    }

    private static class ThreadB extends Thread {
        private final ThreadA threadA;

        public ThreadB(ThreadA threadA) {
            this.threadA = threadA;
        }

        @Override
        public void run() {
            try {
                threadA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ThreadB");
        }
    }

    /**
     * 虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。
     */
    private void test() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);
        threadB.start();
        threadA.start();
    }

    public static void main(String[] args) {
        ThreadJoinDemo threadJoinDemo = new ThreadJoinDemo();
        threadJoinDemo.test();
    }
}
