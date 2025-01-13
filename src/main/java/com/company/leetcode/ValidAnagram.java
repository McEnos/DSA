package com.company.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    public static void main(String[] args) {

    }

    private static boolean solution(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);
        return Arrays.equals(aCharArray, bCharArray);
    }

    private static boolean solutionV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.computeIfPresent(c, (key, value) -> value - 1);
        }
        return true;
    }
}
