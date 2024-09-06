package com.company.leetcode75.slidingwindow;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
 * https://chatgpt.com/share/670f4254-d1bf-435d-87f1-0652537ae437
 */
public class LongestSubArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,0,1}));
        System.out.println(solution(new int[] {0,1,1,1,0,1,1,0,1}));
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
            /**
             * In this case, however, we are tasked with deleting exactly one element from the window,
             * so we need to account for that by excluding one element from the window length calculation.
             */
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
