package com.company.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=array
 * 16 3Sum Closest
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
}
