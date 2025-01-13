package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/monotonic-array/
 * monotonicity of an array is a global property. If the condition A[i] <= A[i+1] (for increasing) or A[i] >= A[i+1]
 * (for decreasing) holds true for all adjacent pairs, then the entire array is guaranteed to be monotonic.
 * Key Idea: Transitivity of Monotonicity
 *
 */
public class IsMonotonic {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            }
        }

        return isDecreasing || isIncreasing;
    }
}
