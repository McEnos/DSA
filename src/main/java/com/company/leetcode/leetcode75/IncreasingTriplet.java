package com.company.leetcode.leetcode75;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/334
 */
public class IncreasingTriplet {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums) {
        // Initialize two variables to hold the smallest and the middle value found so far.
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        // Iterate over each number in the array.
        for (int num : nums) {
            // If the current number is greater than the middle value found,
            // an increasing triplet sequence exists.
            if (num > middle) {
                return true;
            }
            // If the current number is the smallest we've seen so far,
            // we update the smallest value.
            if (num <= smallest) {
                smallest = num;
            } else {
                // Otherwise, if it's between the smallest and the middle value,
                // we update the middle value.
                middle = num;
            }
        }
        // If we did not return true within the loop, then no increasing
        // triplet sequence was found.
        return false;
    }
}
