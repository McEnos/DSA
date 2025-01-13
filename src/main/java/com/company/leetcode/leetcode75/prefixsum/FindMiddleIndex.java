package com.company.leetcode.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 */
public class FindMiddleIndex {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
