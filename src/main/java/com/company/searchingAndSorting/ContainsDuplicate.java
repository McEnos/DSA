package com.company.searchingAndSorting;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 4, 3, 2, 3}));
    }

    private static boolean solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    private static boolean solutionV2(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        return set.size() != a.length;
    }
}
