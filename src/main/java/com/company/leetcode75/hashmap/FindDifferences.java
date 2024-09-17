package com.company.leetcode75.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/solutions/5557376/easy-java-solution-hashset-approach
 */
public class FindDifferences {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(solution(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
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
        List<Integer> diff1 = new ArrayList<>(set1);
        diff1.removeAll(set2);

        List<Integer> diff2 = new ArrayList<>(set2);
        diff2.removeAll(set1);
        result.add(diff1);
        result.add(diff2);

        return result;
    }
}
