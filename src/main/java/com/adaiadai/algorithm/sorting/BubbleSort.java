package com.adaiadai.algorithm.sorting;

import java.util.Arrays;

/**
 * <p>
 * 冒泡排序（bubble sort）通过连续地比较与交换相邻元素实现排序。这个过程就像气泡从底部升到顶部一样，因此得名冒泡排序。
 * 冒泡过程可以利用元素交换操作来模拟：从数组最左端开始向右遍历，依次比较相邻元素大小，如果“左元素 > 右元素”就交换二者。遍历完成后，最大的元素会被移动到数组的最右端。
 * </p>
 */
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
