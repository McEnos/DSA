package com.company.leetcode.leetcode75.twopointers;

/**
 * A subsequence of a string is a new string that is formed from the
 * original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

/**
 * https://algo.monster/liteproblems/392
 * https://leetcode.com/problems/is-subsequence/submissions/1375976726/?envType=study-plan-v2&envId=leetcode-75
 */
public class IsSubsequence {
    public static void main(String[] args) {

    }

    private static boolean solution(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        // Iterate over both strings
        while (sPointer < s.length() && tPointer < t.length()) {
            // Check if the current character of s matches the current character of t
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                // If they match, move the pointer of s forward
                sPointer++;
            }
            // Move the pointer of t forward
            tPointer++;
        }
        // If indexS is equal to the length of s, all characters of s are found in t in sequence
        // Therefore, s is a subsequence of t
        return sPointer == s.length();
    }
}
