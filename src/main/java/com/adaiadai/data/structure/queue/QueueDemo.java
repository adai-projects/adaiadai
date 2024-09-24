package com.adaiadai.data.structure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        /* 访问队首元素 */
        int peek = queue.peek();

        /* 元素出队 */
        int pop = queue.poll();

        /* 获取队列的长度 */
        int size = queue.size();

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
    }
}
