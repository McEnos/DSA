package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-vowels-from-a-string/
 * https://algo.monster/liteproblems/1119
 */
public class RemoveVowelsFromString {
    public static void main(String[] args) {

    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        for (char c : s.toCharArray()) {
            if (!vowels.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
