package com.company.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=hash-table
 * 219 Contains Duplicate ii
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i] - i)) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
