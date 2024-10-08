package com.company.leetcode75;

public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(solution("abc","pqr"));
        System.out.println(solution("ab","pqrs"));
        System.out.println(solution("abcd","pq"));
    }

    public static String solution(String word1, String word2) {
        int i = 0;
        int j = 0;
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
