package com.company.leetcode75.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/?envType=problem-list-v2&envId=two-pointers
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 5,1};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void solution(int[] nums) {
        int i = nums.length - 2;
        // Step 1: Find the pivot (first decreasing element from the right)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // Step 2: If found a valid pivot, find the next larger number to swap with
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >=0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap the pivot with this number
            swap(nums, i, j);
        }
        // Step 3: Reverse the suffix to make it the smallest permutation
        reverse(nums, i + 1);
    }

    // Helper method to reverse elements from start to end in the array
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
