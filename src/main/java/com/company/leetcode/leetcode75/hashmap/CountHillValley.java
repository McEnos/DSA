package com.company.leetcode.leetcode75.hashmap;

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 * https://algo.monster/liteproblems/2210
 */
public class CountHillValley {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(solution(new int[]{6, 6, 5, 5, 4, 1}));
    }

    private static int solution(int[] nums) {
        int count = 0;
        int left = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if ((left < nums[i] && nums[i] > nums[i + 1]) || (left > nums[i] && nums[i] < nums[i + 1])) {
                count++;
                left = nums[i];
            }
        }
        return count;
    }
}
