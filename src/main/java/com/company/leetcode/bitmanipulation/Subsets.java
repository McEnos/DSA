package com.company.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/?envType=problem-list-v2&envId=bit-manipulation
 * 78 Subsets
 */
public class Subsets {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Generate all possible subsets (2^n possibilities)
        for (int i = 0; i < (1 << n); i++) { // (1 << n) = 2^n
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
