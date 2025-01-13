package com.company.leetcode.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * 1498 Number of SubSequences That satisfy the given sum condition
 *
 *
 */
public class NumSubseq {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        // Precompute powers of 2 modulo MOD
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                count = (count + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
