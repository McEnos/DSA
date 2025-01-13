package com.company.leetcode.arrays;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {

    }

    private static boolean solution(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= valueDiff) {
                return true;
            }
            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= indexDiff) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
