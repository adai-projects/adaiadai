package com.adaiadai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 获取最大值
        int max = 0;
        for (int j : candies) {
            if (j > max) {
                max = j;
            }
        }
        // 判断
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{4, 2, 1, 1, 2};
        int extraCandies = 1;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
