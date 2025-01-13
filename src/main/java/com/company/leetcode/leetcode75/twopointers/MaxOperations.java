package com.company.leetcode.leetcode75.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/1679
 */
public class MaxOperations {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int k) {
        // Sort the array to use two pointers approach
        Arrays.sort(nums);
        // Initialize two pointers, one at the start (left) and one at the end (right) of the array
        int left = 0;
        int right = nums.length - 1;
        // Initialize the count variable to count the number of operations
        int count = 0;
        // Use a while loop to move the two pointers towards each other
        while (left < right) {
            // Calculate the sum of the two-pointer elements
            int sum = nums[left] + nums[right];
            // Check if the sum is equal to k
            if (sum == k) {
                // If it is, increment the number of operations
                // Move the left pointer to the right and the right pointer to the left
                count++;
                left++;
                right--;
            }
            if (sum < k) {
                // If the sum is less than k, we need to increase the sum
                // We do this by moving the left pointer to the right
                left++;
            } else {
                // If the sum is greater than k, we need to decrease the sum
                // We do this by moving the right pointer to the left
                right--;
            }
        }
        return count;
    }
}
