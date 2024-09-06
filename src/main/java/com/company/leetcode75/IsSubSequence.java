package com.company.leetcode75;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
public class IsSubSequence {
    public static void main(String[] args) {
        System.out.println(solution("abc", "ahbgdc"));
        System.out.println(solution("axc", "ahbgdc"));
    }

    private static boolean solution(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length();

    }
}
