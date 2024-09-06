package com.company.leetcode75.twopointers;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/solutions/5700388/two-pointers-technique
 */
public class ReverseStringWords {
    public static void main(String[] args) {
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello world  "));
        System.out.println(solution("a good   example"));
    }

    private static String solution(String s) {
        /**
         * remove leading and trailing spaces
         * split individual words using and spaces within the whole string
         * Then apply two pointers technique, where one pointer
         * starts from the beginning of the resulting array while the other starts from the end of the array
         * swap words at the indexes and advance the beginning index towards the end while end index towards the beginning
         * which will make the indexes to meet at some point.
         * Make string out of the resulting reversed words array
         */
        String[] words = s.trim().split("\\s+");

        int i = 0;
        int j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", words);
    }
}
