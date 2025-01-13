package com.company.leetcode75.bitmanipulation;

import java.util.*;

/**
 * https://leetcode.com/problems/single-number-iii/description/
 */
public class SingleNumber2 {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                result.add(i);
            }
        }
        return new int[]{result.get(0), result.get(1)};
    }

    private static int[] solutionV2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }
}
