package com.adaiadai.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {

    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5 * 1000);
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.execute(() -> {
                localVariable.set(new LocalVariable());
                System.out.println("use local variable" + localVariable.get());
//                localVariable.remove();
            });
        }
        System.out.println("pool execute over");
    }

}
