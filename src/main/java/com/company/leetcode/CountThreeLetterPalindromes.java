package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountThreeLetterPalindromes {
    public static void main(String[] args) {
        System.out.println(solution("dd"));
        System.out.println(solution("aaaabc"));
        System.out.println(solution("xyvzwy"));
        System.out.println(solution("fknfkn"));
    }

    private static int solution(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // Step 2: Calculate the total number of pairs
        int totalPairs = 0;
        for (int count : freqMap.values()) {
            totalPairs += (count / 2);  // Each pair requires 2 identical letters
        }
        // Step 3: Calculate the maximum number of 3-letter palindromes
        // Each palindrome needs one pair and one more character (middle letter)
        return Math.min(totalPairs, s.length() / 3);
    }
}
