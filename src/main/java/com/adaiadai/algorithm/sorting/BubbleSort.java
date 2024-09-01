package com.adaiadai.algorithm.sorting;

import java.util.Arrays;

public class BubbleSort {

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
