package com.company.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

}
