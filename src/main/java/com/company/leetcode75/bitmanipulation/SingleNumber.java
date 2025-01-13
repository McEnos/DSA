package com.company.leetcode75.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/single-number/solutions/5800667/99-beats-bits-java-explained
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 1}));
        System.out.println(solution(new int[]{4, 1, 2, 1, 2}));
        System.out.println(solution(new int[]{1}));
    }

    private static int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
