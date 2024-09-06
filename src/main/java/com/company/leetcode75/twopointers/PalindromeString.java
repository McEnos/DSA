package com.company.leetcode75.twopointers;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(solution("dadad"));
    }

    private static boolean solution(String s) {
        char[] stringArray = s.toCharArray();
        int start = 0;
        int end = stringArray.length - 1;
        while (start < end) {
            if (stringArray[start] != stringArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
