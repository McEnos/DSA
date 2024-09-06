package com.company.leetcode75.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumAverage {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(solution(new int[]{5},1));
    }

    private static double solution(int[] nums, int k) {
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxAverage = windowSum / k;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            double average = windowSum / k;
            maxAverage = Math.max(maxAverage, average);
        }
        return maxAverage;

    }
}
