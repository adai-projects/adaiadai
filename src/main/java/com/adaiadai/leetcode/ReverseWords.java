package com.adaiadai.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Hello World"));
    }

    static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] s1 = s.split("\\s+");
            List<String> list = Arrays.asList(s1);
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }
}
