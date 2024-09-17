package com.company.leetcode75.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/description/
 * Given an array of integers nums and a target value target, return the number of triplets [nums[i], nums[j], nums[k]] such that:
 */
public class ThreeSumSmallest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 0, 1, 3},2));
    }

    private static int solution(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int count = 0;
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Step 3: Use two pointers to find pairs that satisfy the condition
            int left = i + 1;
            int right = nums.length - 1;
            int currentSum = nums[i] + nums[left] + nums[right];
            // Step 4: Check if the sum of the triplet is smaller than the target
            if (currentSum < target) {
                // If the sum is smaller, all elements between left and right form valid triplets
                count += right - left;
                left++; // Move the left pointer to explore more pairs
            } else {
                // If the sum is greater or equal, move the right pointer to reduce the sum
                right--;
            }
        }
        return count;

    }
}
