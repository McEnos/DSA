package com.company.leetcode.leetcode75.twopointers;

/**
 * https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/283
 */
public class MoveZeroes {
    public static void main(String[] args) {

    }

    private static void solution(int[] nums) {
        int length = nums.length;
        int position = 0;
        for(int num: nums){
            if(num != 0){
                nums[position++] = num;
            }
        }
        while (position < length){
            nums[position++] = 0;
        }
    }
}
