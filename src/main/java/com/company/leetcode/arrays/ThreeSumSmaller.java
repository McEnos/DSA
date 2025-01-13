package com.company.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/description/
 * https://algo.monster/liteproblems/259
 * 259. 3Sum Smaller
 * <p>
 * The problem provides us with an array of integers nums and another integer target.
 * Our task is to count the number of unique triplets (i, j, k), where i, j,
 * and k are the indices in the array such that 0 <= i < j < k < n,
 * and the sum of the elements at these indices is less than the given target.
 * More formally, we want to find the count of combinations where nums[i] + nums[j] + nums[k] < target.
 */
public class ThreeSumSmaller {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            int secondIndex = firstIndex + 1;
            int thirdIndex = nums.length - 1;
            while (secondIndex < thirdIndex) {
                int sum = nums[firstIndex] + nums[secondIndex] + nums[thirdIndex];
                // If the sum is greater than or equal to the target, move the 'thirdIndex' pointer
                // to the left to reduce sum.
                if (sum >= target) {
                    thirdIndex--;
                } else {
                    // If the sum is less than the target, count all possible third elements by adding
                    // the distance between 'thirdIndex' and 'secondIndex' to the 'count'
                    // because all elements to the left of 'thirdIndex' would form a valid triplet.
                    count += thirdIndex - secondIndex;
                    // Move the 'secondIndex' pointer to the right to find new pairs.
                    secondIndex++;
                }
            }
        }
        return count;
    }
}
