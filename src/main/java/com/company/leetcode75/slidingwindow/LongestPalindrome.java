package com.company.leetcode75.slidingwindow;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    private static String solution(String s) {
        int left = 0;

        return "";
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
