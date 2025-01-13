package com.company.leetcode.leetcode75;

/**
 * https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeAlternately {
    public static void main(String[] args) {

    }

    private static String solution(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}

