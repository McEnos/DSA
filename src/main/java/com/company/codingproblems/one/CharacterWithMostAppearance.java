package com.company.codingproblems.one;

import java.util.HashMap;
import java.util.Map;

public class CharacterWithMostAppearance {
    public static void main(String[] args) {
        System.out.println(solution("joshua"));
    }

    private static char solution(String value) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : value.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int maxOccurrence = 0;
        for (Integer v : map.values()) {
            maxOccurrence = Math.max(v, maxOccurrence);
        }
      //  Integer max = Collections.max(map.values());
        for (char key : map.keySet()) {
            if (map.get(key) == maxOccurrence) {
                return key;
            }
        }

        return Character.MIN_VALUE;
    }
}
