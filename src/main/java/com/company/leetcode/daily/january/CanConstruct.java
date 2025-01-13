package com.company.leetcode.daily.january;

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings
 */
public class CanConstruct {
    public static void main(String[] args) {

    }

    private static boolean solution(String s, int k) {
        // If the input string is shorter than the required number of palindromes,
        // it is not possible to construct the palindromes.
        if (s.length() < k) {
            return false;
        }
        // Array to hold the count of each character in the inputString.
        int[] frequency = new int[26];

        // Count the frequency of each character in the inputString.
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        // Count the number of characters that appear an odd number of times.
        int oddCount = 0;
        for (int count : frequency) {
            oddCount += count % 2;
        }
        // It is possible to form palindromes if the number of characters with
        // odd frequency is less than or equal to the number of palindromes we need to construct.
        return oddCount <= k;
    }

}
