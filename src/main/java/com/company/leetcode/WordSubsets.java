package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/description/
 */
public class WordSubsets {
    public static void main(String[] args) {

    }

    private static List<String> solution(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];

        for (String word : words2) {
            int[] freq = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = countFrequency(word);
            if (isSubSet(freq, maxFreq)) {
                result.add(word);
            }
        }
        return result;
    }

    //Helper method to check if 'wordFreq' satisfies 'maxFreq' requirement
    private static boolean isSubSet(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    // get the frequency of each character in the word
    private static int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
