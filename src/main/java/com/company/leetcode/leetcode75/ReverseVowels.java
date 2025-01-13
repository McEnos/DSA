package com.company.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/345
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(solution("IceCreAm"));
    }

    private static String solution(String s) {
        // Convert the input string to a character array for easy manipulation.
        char[] characters = s.toCharArray();
        // Initialize two pointers, one at the start (i) and one at the end (j) of the character array.
        int i = 0;
        int j = s.length() - 1;
        // Use a while loop to traverse the character array from both ends until they meet or cross.
        while (i < j) {
            // Move the start pointer forward if the current character is not a vowel.
            while (i < j && !isVowel(characters[i])) {
                ++i;
            }
            // Move the end pointer backward if the current character is not a vowel.
            while (i < j && !isVowel(characters[j])) {
                --j;
            }
            // Check if the pointers haven't crossed; swap the vowels if needed.
            if (i < j) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                // After swapping, move both pointers to continue to the next characters.
                ++i;
                --j;
            }
        }
        // Convert the character array back into a string and return it.
        return String.valueOf(characters);
    }

    private static boolean isVowel(char c) {
        return Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }

    private static String solutionV2(String s) {
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );
        for (char c : characters) {
            if (vowels.contains(c)) {
                stack.push(c);
            }
        }
        for (int i = 0; i < characters.length; i++) {
            if (vowels.contains(characters[i])) {
                characters[i] = stack.pop();
            }
        }
        return String.valueOf(characters);
    }
}
