package com.company.leetcode75.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/?envType=problem-list-v2&envId=two-pointers
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1,2,1,-4},1));
        System.out.println(solution(new int[]{0,0,0},1));
    }

    private static int solution(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize the closest sum with the first three elements
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Step 2: Initialize left pointer
            int right = nums.length - 1;  // Step 2: Initialize right pointer
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];  // Current sum of triplet
                // Step 3: Check if the current sum is closer to the target than the closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                if (currentSum < target) {
                    left++;// Move left pointer to the right to increase the sum
                } else if (currentSum > target) {
                    right--; // Move right pointer to the left to decrease the sum
                } else {
                    return currentSum;  // If currentSum == target, we found the closest sum possible
                }
            }

        }
        return closestSum;
    }
}
