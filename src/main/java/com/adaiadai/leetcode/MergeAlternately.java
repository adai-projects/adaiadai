package com.adaiadai.leetcode;

public class MergeAlternately {

    public static String mergeAlternately(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        char[] target = new char[charArray1.length + charArray2.length];
        int i = 0, j = 0;
        while (i < charArray1.length + charArray2.length) {
            if (j < charArray1.length) {
                target[i] = charArray1[j];
                i++;
            }
            if (j < charArray2.length) {
                target[i] = charArray2[j];
                i++;
            }
            j++;
        }
        return new String(target);
    }


    public static void main(String[] args) {
        System.out.printf(mergeAlternately("abcd", "pq"));
    }

}
