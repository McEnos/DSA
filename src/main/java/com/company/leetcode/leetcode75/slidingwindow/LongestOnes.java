package com.company.leetcode.leetcode75.slidingwindow;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/1004
 */
public class LongestOnes {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int k) {
        int maxLength = 0;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
