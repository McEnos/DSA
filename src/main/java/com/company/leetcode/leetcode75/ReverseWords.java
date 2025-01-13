package com.company.leetcode.leetcode75;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/151
 */
public class ReverseWords {
    public static void main(String[] args) {

    }

    private static String solution(String s) {
        // Trim the input string to remove leading and trailing whitespaces
        // and split it into an array of words based on one or more whitespace characters
        String[] wordsArray = s.trim().split("\\s+");
        int left = 0;
        int right = wordsArray.length - 1;

        while (left < right) {
            String temp = wordsArray[left];
            wordsArray[left] = wordsArray[right];
            wordsArray[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", wordsArray);
    }
}
