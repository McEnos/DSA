package com.company.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 */
public class FindMiddleIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,-1,8,4}));
        System.out.println(solution(new int[]{1,-1,4}));
        System.out.println(solution(new int[]{2,5}));
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
