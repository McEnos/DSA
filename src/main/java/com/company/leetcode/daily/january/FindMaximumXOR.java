package com.company.leetcode.daily.january;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * https://algo.monster/liteproblems/421
 */
public class FindMaximumXOR {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int current = nums[i] ^ nums[j];
                max = Math.max(current, max);
            }
        }
        return max;
    }


}
