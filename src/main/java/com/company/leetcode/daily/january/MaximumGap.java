package com.company.leetcode.daily.january;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap
 */
public class MaximumGap {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0; // No gap possible with less than 2 numbers
        }
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Find the maximum gap
        int maxGap = 0;

        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;


    }

    private static int solutionV2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // Step 1: Find the minimum and maximum elements

        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int num : nums) {
            minElement = Math.min(num, minElement);
            maxElement = Math.max(num, maxElement);
        }
        if (minElement == maxElement) {
            return 0; // All elements are identical
        }
        // Step 2: Calculate bucket size and count

        int n = nums.length;
        int bucketSize = Math.max(1, (maxElement - minElement) / (n - 1));
        int bucketCount = (maxElement - minElement) / bucketSize + 1;

        //Step 3: Initialize buckets
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Step 4: Distribute elements into buckets
        for (int num : nums) {
            int bucketIndex = (num - minElement) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
        }

        //Step 5: Calculate the max Gap
        int maxGap = 0;
        int previousMax = minElement;

        for (int i = 0; i < bucketSize; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue; //skip empty buckets
            }
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        return maxGap;


    }
}
