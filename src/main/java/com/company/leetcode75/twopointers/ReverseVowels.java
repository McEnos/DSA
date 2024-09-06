package com.company.leetcode75.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution("leetcode"));
    }

    private static String solution(String str) {
        Stack<Character> vowelStack = new Stack<Character>();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] result = str.toCharArray();
        for (char c : result) {
            if (vowels.contains(c)) {
                vowelStack.push(c);
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (vowels.contains(result[i])) {
                result[i] = vowelStack.pop();
            }
        }
        return new String(result);
    }

    private static String solutionV2(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            while (start < end && !isVowel(chars[start])) {
                start++;
            }
            while (start < end && !isVowel(chars[end])) {
                end--;
            }
            if (start < end) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }
        return new String(chars);

    }

    private static void swap(char[] word, int start, int end) {
        char temp = word[start];
        word[start] = word[end];
        word[end] = temp;
    }

    private static boolean isVowel(char c) {
        return Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }
}
