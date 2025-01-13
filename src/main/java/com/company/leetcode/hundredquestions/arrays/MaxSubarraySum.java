package com.company.leetcode.hundredquestions.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 53. Maximum Subarray
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * [Naive Approach] By iterating over all sub-arrays – O(n^2) Time and O(1) Space
     */
    private int solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        // Outer loop: Starting point of subarray
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            // Inner loop: Ending point of subarray
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j]; // Sum of subarray from i to j
                max = Math.max(max, currentSum);  // Update maxSum if needed
            }
        }
        return max;
    }

    /**
     * Kadane algorithm O(n) Time and O(1) Space
     * Kadane's Algorithm is an efficient method to solve the Maximum Subarray Sum problem
     * Key Concept:
     * Kadane's Algorithm relies on the idea that we can compute the maximum subarray ending at each position by deciding whether to:
     *      Extend the current subarray to include the current element, or
     *      Start a new subarray from the current element itself.
     * Approach:
     *      Current Subarray Sum (currentSum): At each step, you decide if the current element should be added to the previous
     *      subarray sum or if you should start fresh from the current element.
     * <p>
     *      Maximum Subarray Sum (maxSum): This tracks the maximum sum encountered so far.
     * <p>
     *      The main insight behind Kadane's Algorithm is:
     *          If at any point the sum of the current subarray becomes less than the current element itself,
     *          it is better to discard the previous subarray and start a new one at the current position.
     */
    private static int solution2(int[] nums) {
        // Initialize variables to store the maximum sum
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Find the maximum sum ending at index i by either extending
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // Update maxSum if maximum subarray sum ending at index i > maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;

    }
}
