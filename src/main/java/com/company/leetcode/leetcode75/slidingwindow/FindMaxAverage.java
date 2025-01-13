package com.company.leetcode.leetcode75.slidingwindow;

/**
 * https://algo.monster/liteproblems/643
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindMaxAverage {
    public static void main(String[] args) {

    }

    private static double solution(int[] nums, int k) {
        double windowSum = 0;
        // Sum of the first 'k' elements.
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxAverage = windowSum / k;
        // Iterate through the array starting from the k-th element.
        for (int i = k; i < nums.length; i++) {
            // Update the current window sum by adding the new element
            // and subtracting the first element of the previous window.
            windowSum += nums[i] - nums[i - k];
            double currentAverage = windowSum / k;
            maxAverage = Math.max(maxAverage, currentAverage);
        }
        return maxAverage;
    }

    private static double solution2(int[] nums, int k) {
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        double maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum / k;
    }
}
