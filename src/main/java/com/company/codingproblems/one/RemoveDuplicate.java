package com.company.codingproblems.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        System.out.println(solution("jooosGRRRRhua"));
    }

    private static String solution(String value) {
        Set<Character> characters = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (characters.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String solutionV2(String value) {
        return Arrays.stream(
                        value.split("")
                )
                .distinct()
                .collect(Collectors.joining());
    }
}
