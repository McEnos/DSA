package com.company.codingproblems.one;

import java.util.List;
import java.util.Map;

public class VowelAndConsonants {
    public static void main(String[] args) {
        System.out.println(solution("JosGRhua"));
    }

    private static Map<Character, Integer> solution(String value) {
        value = value.toLowerCase();
        int vowelsCount = 0;
        int consonantsCount = 0;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        for (char c : value.toCharArray()) {
            if (vowels.contains(c)) {
                vowelsCount += 1;
            } else if (c >= 'a' && c <= 'z') {
                consonantsCount += 1;
            }
        }
        return Map.of('v', vowelsCount,
                'c', consonantsCount
        );


    }

    private static Map<Character, Long> solutionV2(String value) {
        value = value.toLowerCase();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        return Map.of(
                'v', value.chars().filter(vowels::contains).count(),
                'c', value.chars()
                        .filter(v -> !vowels.contains(v) && v >= 'a' && v <= 'z').count()
        );
    }
}
