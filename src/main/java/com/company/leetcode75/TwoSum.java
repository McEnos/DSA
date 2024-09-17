package com.company.leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution(new int[]{3,2,4}, 6)));
    }

    private static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No Match");
    }
}
