package com.company.leetcode.hundredquestions.arrays;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for (int num : nums) {
            seen[num] = true;
        }
        for(int i = 0; i <= n; i++){
            if(!seen[i]){
                return i;
            }
        }
        return -1;
    }
}
