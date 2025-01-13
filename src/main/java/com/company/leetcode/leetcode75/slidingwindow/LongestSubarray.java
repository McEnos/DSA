package com.company.leetcode.leetcode75.slidingwindow;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/1493
 */
public class LongestSubarray {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
