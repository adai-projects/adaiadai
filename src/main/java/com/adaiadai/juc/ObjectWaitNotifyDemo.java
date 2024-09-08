package com.adaiadai.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectWaitNotifyDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        new Consumer(queue).start();
        new Producer(queue, 5).start();
    }
}

@Slf4j
class Consumer extends Thread {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            // 在条件判断之前给共享资源加锁
            while (true) {
                while (queue.isEmpty()) {
                    log.info("消息队列为空，消费者进入等待状态");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.info("消费者，消费信息: {}", queue.remove());
                // 通知
                queue.notifyAll();
            }
        }
    }

}

/**
 * 生产者
 */
@Slf4j
class Producer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;

    private int count;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                while (queue.size() == maxSize) {
                    log.info("消息队列满了，生产者进入等待状态");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    // 让生产者每1秒钟生产一条消息
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int message = count++;
                // 将消息写入队列
                queue.add(message);
                log.info("生产者，添加消息：: {}", message);
                // 通知消费者线程，对消息进行消费
                queue.notifyAll();
            }

        }
    }

}
