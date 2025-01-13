package com.company.leetcode.hundredquestions.arrays;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class Sort012 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solutionV2(new int[]{0, 1, 2, 0, 1, 2})));
    }

    /**
     * The Dutch National Flag Algorithm
     */
    private static int[] solution(int[] nums) {
        int low = 0;  // Pointer for the next position of 0
        int mid = 0; // Pointer for the current position
        int high = nums.length - 1; // Pointer for the next position of 2
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
        return nums;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * Time O(n)
     * Space O(1)
     */
    private static int[] solutionV2(int[] nums) {
        int twos = 0;
        int ones = 0;
        int zeros = 0;
        // Count 0s, 1s and 2s
        for (int num : nums) {
            if (num == 2) {
                twos++;
            } else if (num == 1) {
                ones++;
            } else {
                zeros++;
            }
        }
        int idx = 0;
        // Place all the 0s
        for (int i = 0; i < zeros; i++) {
            nums[idx++] = 0;
        }
        // Place all the 1s
        for (int i = 0; i < ones; i++) {
            nums[idx++] = 1;
        }
        // Place all the 2s
        for (int i = 0; i < twos; i++) {
            nums[idx++] = 2;
        }
        return nums;

    }
}
