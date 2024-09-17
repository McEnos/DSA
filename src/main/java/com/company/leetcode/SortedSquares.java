package com.company.leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SortedSquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(solution(new int[]{-7,-3,2,3,11})));
    }

    private static int[] solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
