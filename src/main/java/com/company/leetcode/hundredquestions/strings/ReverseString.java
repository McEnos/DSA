package com.company.leetcode.hundredquestions.strings;

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(solution(new char[]{'h','e','l','l','o'}));
    }

    private static char[] solution(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
        return s;
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
