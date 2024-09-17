package com.company.leetcode;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int maxOnes = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                currentCount = 0;
            }
            maxOnes = Math.max(maxOnes, currentCount);
        }
        return maxOnes;
    }

}
