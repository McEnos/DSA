package com.company.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75
 */
public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(solutionV2(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solutionV2(new int[]{1, 2, 3}));
        System.out.println(solutionV2(new int[]{2, 1, -1}));
    }

    private static int solutionV2(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    private static int solution(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int prefix = prefix(nums, i);
            int suffix = suffix(nums, i);
            if (prefix == suffix) {
                return i;
            }
        }
        return -1;
    }

    private static int prefix(int[] nums, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private static int suffix(int[] nums, int index) {
        int sum = 0;
        for (int i = index + 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
