package com.company.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        //System.out.println(solution());
    }

    private static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Count occurrences of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Find the unpaired element
        for (int key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                return key;
            }
        }
        return -1;
    }
}
