package com.company.codingproblems.one;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {
    public static void main(String[] args) {
        System.out.println(solution("Jjjoshua"));
    }

    private static Map<Character, Integer> solution(String value) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : value.toCharArray()) {
            result.compute(c, (k, v) -> (v == null) ? 1 : v+1);
        }
        return result;
    }
}
