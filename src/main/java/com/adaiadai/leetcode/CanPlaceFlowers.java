package com.adaiadai.leetcode;

public class CanPlaceFlowers {

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int[] copy = new int[flowerbed.length + 2];
            System.arraycopy(flowerbed, 0, copy, 1, flowerbed.length);
            int count = 0;
            for (int i = 1; i < copy.length - 1; i++) {
                if (copy[i - 1] + copy[i] + copy[i + 1] == 0) {
                    i += 1;
                    count++;
                }
            }
            return n <= count;
        }
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 0, 1};
        int n = 2;
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(flowerbed, n));
    }

}
