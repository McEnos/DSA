package com.company.codingproblems.one;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(solution("kkeeviin"));
    }

    private static char solution(String value) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        //insertion-order map
        for (char c : value.toCharArray()) {
            map.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return Character.MIN_VALUE;
    }
}
