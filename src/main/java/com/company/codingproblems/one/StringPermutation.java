package com.company.codingproblems.one;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
    public static void main(String[] args) {

    }

    private static Set<String> solution(String value, String prefix) {
        Set<String> permutations = new HashSet<>();
        int n = value.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(solution(prefix + value.charAt(i),
                        value.substring(i + 1, n) + value.substring(0, i)));
            }
        }


        return permutations;
    }
}
