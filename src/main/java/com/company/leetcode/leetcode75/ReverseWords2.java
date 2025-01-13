package com.company.leetcode.leetcode75;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 * https://algo.monster/liteproblems/186
 */
public class ReverseWords2 {
    public static void main(String[] args) {
        char[] input = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        solution(input);
        System.out.println(input);
    }

    private static void solution(char[] s) {
        int n = s.length;
        // First, reverse each word in the array
        for (int start = 0, end = 0; end < n; ++end) {
            if (s[end] == ' ') {
                // When we find a space, reverse the previous word
                reverse(s, start, end - 1);
                // Move to the start of the next word
                start = end + 1;
            } else if (end == n - 1) {
                // If this is the end of the last word, reverse it
                reverse(s, start, end);
            }
        }
        // After all words are reversed, reverse the entire array to put words into the correct order
        reverse(s, 0, n - 1);
    }

    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
