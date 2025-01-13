package com.company.leetcode.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/724
 */
public class PivotIndex {
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
