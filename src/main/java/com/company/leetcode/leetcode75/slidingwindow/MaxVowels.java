package com.company.leetcode.leetcode75.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/1456
 */
public class MaxVowels {
    public static void main(String[] args) {

    }

    private static int solution(String s, int k) {
        int windowSum = 0;
        List<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        // Count the number of vowels in the initial window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                windowSum++;
            }
        }
        // Initialize the answer with the vowel count of the first window
        int maxVowels = windowSum;
        // Slide the window of size k across the string
        for (int i = k; i < s.length(); i++) {
            int outgoingIndex = i - k;
            // If the character that got excluded from the window is a vowel, decrease the count
            if (vowels.contains(s.charAt(outgoingIndex))) {
                windowSum--;
            }
            // If the newly included character is a vowel, increase the count
            if (vowels.contains(s.charAt(i))) {
                windowSum++;
            }
            // Update maxVowels if the current window has more vowels than the previous ones
            maxVowels = Math.max(maxVowels, windowSum);
        }
        // Return the maximum number of vowels found
        return maxVowels;
    }

}
