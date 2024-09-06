package com.company.leetcode75.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/solutions/5501578/simple-code-easy-to-understand-beats-100-beginner-friendly
 */
public class MaxOperations {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4},5));
        System.out.println(solution(new int[]{3,1,3,4,3},6));
    }

    private static int solution(int[] nums, int target) {
        int operations = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                operations++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return operations;
    }
}
