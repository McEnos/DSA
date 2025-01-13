package com.company.leetcode.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 151. Reverse Words in a String
 */
public class ReverseWords {
    public static void main(String[] args) {

    }

    private static String solution(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

}
