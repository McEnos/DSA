package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/description/
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * 487. Max Consecutive Ones II
 * https://algo.monster/liteproblems/487
 */
public class FindMaxConsecutiveOnes11 {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int left = 0;  // Initialize the left pointer
        int right = 0;  // Initialize the right pointer
        int allowedZeros = 1;  // Initialize the number of zeros allowed to flip to ones
        while (right < nums.length) {
            // If the current element is 0, decrement the number of zeros allowed
            if (nums[right++] == 0) {
                allowedZeros--;
            }
            // If no zeros are allowed and the left element is 0, increment the left pointer
            // and the number of zeros allowed
            if (allowedZeros < 0 && nums[left++] == 0) {
                allowedZeros++;
            }
        }
        // Compute the length of the longest sequence of 1s (with at most one 0 flipped to 1)
        return right - left;
    }
}
