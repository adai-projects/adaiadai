package com.adaiadai.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierResetDemo {

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                long end = System.currentTimeMillis();
                System.out.println("导入" + 3 + "条数据，至此总共用时：" + (end - start)
                        + "毫秒");
            }
        });

        for (int i = 0; i < 9; i++) {
            final int threadID = i + 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 模拟业务操作
                        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                        System.out.println(threadID + "完成导入操作。");
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("====主线程结束====");
    }
}
