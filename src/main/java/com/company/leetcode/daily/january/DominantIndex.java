package com.company.leetcode.daily.january;

/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class DominantIndex {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        if (nums == null)
            return -1;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        boolean twiceLarger = true;
        for (int num : nums) {
            if (num != max && num > 0) {
                int divisor = max / num;
                if (divisor < 2) {
                    twiceLarger = false;
                }
            }
        }
        return twiceLarger ? maxIndex : -1;
    }

    private static int solutionV2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxIndex = -1;
        // Iterate through the array to find the largest and second-largest numbers
        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than the largest found so far,
            // update secondMax to max, and max to the current number
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                // If the current number is only greater than secondMax,
                // update the secondMax to the current number
                secondMax = nums[i];
            }
        }
        // Check if the largest number is at least twice as much as the second largest number
        // If so, return the index of the largest number, otherwise return -1
        return max >= secondMax * 2 ? maxIndex : -1;
    }
}
