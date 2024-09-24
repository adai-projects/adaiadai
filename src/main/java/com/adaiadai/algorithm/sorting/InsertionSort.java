package com.adaiadai.algorithm.sorting;

import java.util.Arrays;

/**
 * <p>
 * 插入排序（insertion sort）是一种简单的排序算法，它的工作原理与手动整理一副牌的过程非常相似。
 * 具体来说，我们在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置。
 * <p>
 */
public class InsertionSort {

    public static void go(int[] arr) {
        int n = arr.length;
        // 总次数 n-1 次
        // 左边是有序的，右边是未排序的，
        for (int i = 1; i < n; i++) {
            int base = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > base) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = base;
        }
    }

    public static void main(String[] args) {
        int[] source = {2, 1, 5, 7, 8, 9, 3, 6, 4};
        System.out.println(Arrays.toString(source));
        go(source);
        System.out.println(Arrays.toString(source));
    }

}
