package com.adaiadai.data.structure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapDemo {

    public static void main(String[] args) {
        // 初始化堆
        // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        // 初始化大顶堆
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 元素入堆
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(4);
        Integer peek = maxHeap.peek();
        // 获取堆顶元素
        System.out.println(peek);

        // 堆顶元素出堆
        // 出堆元素会形成一个从大到小的序列
        peek = maxHeap.poll();
        System.out.println(peek);
        peek = maxHeap.poll();
        System.out.println(peek);
        peek = maxHeap.poll();
        System.out.println(peek);
        peek = maxHeap.poll();
        System.out.println(peek);
        peek = maxHeap.poll();
        System.out.println(peek);

        // 获取堆大小
        int size = maxHeap.size();
        System.out.println("Heap size: " + size);
        // 判断堆是否为空
        boolean empty = maxHeap.isEmpty();
        // 输入列表并建堆
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 5, 2, 5));

    }
}
