package com.adaiadai.algorithm.sorting;

import java.util.Arrays;

/**
 * @author adai
 * <p>
 * 堆排序（heap sort）是一种基于堆数据结构实现的高效排序算法。我们可以利用已经学过的“建堆操作”和“元素出堆操作”实现堆排序。
 * 1. 输入数组并建立小顶堆，此时最小元素位于堆顶。
 * 2. 不断执行出堆操作，依次记录出堆元素，即可得到从小到大排序的序列。
 * 以上方法虽然可行，但需要借助一个额外数组来保存弹出的元素，比较浪费空间。在实际中，我们通常使用一种更加优雅的实现方式。
 * </p>
 */
public class HeapSort {

    private static void go(int[] nums) {
        int length = nums.length;
        // 冒泡
        // 08 07 06
        // [0,9) [0,8]
        // 第一层控制循环次数 （9-1）
        for (int i = 0; i < length - 1; i++) {
            // 第二层控制边界
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] source = {2, 1, 5, 7, 8, 9, 3, 6, 4};
        System.out.println(Arrays.toString(source));
        go(source);
        System.out.println(Arrays.toString(source));
    }

}
