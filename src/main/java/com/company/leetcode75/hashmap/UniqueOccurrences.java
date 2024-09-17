package com.company.leetcode75.hashmap;

import java.util.*;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(solution(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println(solution(new int[]{1, 2}));
    }

    private static boolean solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // store all the occurrences in hashMap of every key
        for (int num : nums) {
            // int currentCount = map.getOrDefault(num, 0);
            //  map.put(num, currentCount + 1);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // check if any occurrence is repeated twice using hashset
        Set<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}
