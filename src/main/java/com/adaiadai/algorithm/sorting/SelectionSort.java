package com.adaiadai.algorithm.sorting;

import java.util.Arrays;

/**
 * <p>
 *     选择排序（selection sort）的工作原理非常简单：开启一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的末尾。
 * </p>
 */
public class SelectionSort {

    public static void min(int[] arr) {
        // [0,n-1]
        int min = 0;
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                min = i;
                minValue = arr[i];
            }
        }
        System.out.println(min);
    }

    public static void go(int[] arr) {
        int length = arr.length;
        // 控制循环次数
        // n-1 次
        // 09 19 29
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            // 未排序区间
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    public static void main(String[] args) {
        int[] source = {2, 1, 5, 7, 8, 9, 3, 6, 4};
        System.out.println(Arrays.toString(source));
        min(source);
        go(source);
        System.out.println(Arrays.toString(source));
    }

}
