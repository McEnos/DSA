package com.company.leetcode.leetcode75.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
 */
public class UniqueOccurrences {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate over the array and populate the map.
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Create a hashset containing all the values (occurrence counts) from the map.
        Set<Integer> set = new HashSet<>(map.values());
      /*  for (int value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }*/
        // If the size of the set (unique occurrences) is the same as the size of the map (unique numbers),
        // it means that all occurrence counts are unique and we return true. Otherwise, return false.
        return set.size() == map.size();
    }
}
