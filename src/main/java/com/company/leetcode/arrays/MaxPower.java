package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/consecutive-characters/
 * 1446: Consecutive characters
 */
public class MaxPower {
    public static void main(String[] args) {
        System.out.println(solution("leetcode"));
        System.out.println(solution("abbcccddddeeeeedcba"));
    }

    private static int solution(String s) {
        int maxConsecutive = 1;
        int currentConsecutive = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentConsecutive++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                currentConsecutive = 1;
            }
        }
        return Math.max(maxConsecutive, currentConsecutive);
    }
}
