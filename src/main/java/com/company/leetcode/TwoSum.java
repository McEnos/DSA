package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] a, int target) throws IllegalAccessException {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int compliment = target - a[i];
            if (result.containsKey(compliment)) {
                return new int[]{result.get(compliment), i};
            }
            result.put(a[i], i);
        }
        throw new IllegalAccessException("No Match");
    }
}
