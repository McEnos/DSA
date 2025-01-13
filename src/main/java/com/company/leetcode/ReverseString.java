package com.company.leetcode;

public class ReverseString {
    public static void main(String[] args) {

    }

    private void solution(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
