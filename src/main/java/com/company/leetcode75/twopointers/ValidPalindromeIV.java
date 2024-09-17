package com.company.leetcode75.twopointers;

/**
 * https://leetcode.com/problems/valid-palindrome-iv/description/
 * https://algo.monster/liteproblems/2330
 * You are given a 0-indexed string s made up of lowercase English letters.
 * To address the problem, you are required to determine if the string s can be turned into a palindrome through exactly one or two operations
 */
public class ValidPalindromeIV {
    public static void main(String[] args) {

    }

    private static boolean solution(String s) {
        int mismatchCount = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            if (Character.toLowerCase(rightChar) != Character.toLowerCase(leftChar)) {
                mismatchCount++;
            }
            if (mismatchCount > 2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
