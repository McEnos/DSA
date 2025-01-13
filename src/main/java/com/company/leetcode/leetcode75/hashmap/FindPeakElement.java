package com.company.leetcode.leetcode75.hashmap;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int left = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (left < nums[i] && nums[i] > nums[i + 1]) {
                left = nums[i];
                return i;
            }
        }
        return 0;
    }
}
