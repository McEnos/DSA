package com.company.leetcode.leetcode75.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/2215
 */
public class FindDifference {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> solution(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}
