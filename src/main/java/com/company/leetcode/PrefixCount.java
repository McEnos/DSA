package com.company.leetcode;

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix
 */
public class PrefixCount {
    public static void main(String[] args) {

    }

    private static int solution(String[] words, String prefix) {
        int count = 0;
        int prefLength = prefix.length();
        for (String word : words) {
            if (word.length() >= prefLength){
                String subString = word.substring(0, prefLength);
                if (subString.equals(prefix)){
                    count++;
                }
            }
        }
        return count;
    }
}
