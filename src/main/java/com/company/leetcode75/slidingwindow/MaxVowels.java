package com.company.leetcode75.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxVowels {
    static Logger logger = Logger.getLogger(MaxVowels.class.getName());
    public static void main(String[] args) {
        logger.info(String.valueOf(solution("abciiidef",3)));
        System.out.println(solutionV2("abciiidef", 3));
        System.out.println(solutionV2("aeiou", 2));
        System.out.println(solutionV2("leetcode", 3));
    }

    private static int solution(String s, int k) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                windowSum += 1;
            }
        }
        int maxVowels = windowSum;
        for (int i = k; i < s.length(); i++) {
            char leavingCharacter = s.charAt(i - k);
            char enteredCharacter = s.charAt(i);
            if (vowels.contains(leavingCharacter)) {
                windowSum -= 1;
            }
            if (vowels.contains(enteredCharacter)) {
                windowSum += 1;
            }
            maxVowels = Math.max(maxVowels, windowSum);
        }

        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }

    private static int solutionV2(String s, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                windowSum += 1;
            }
        }
        int maxVowels = windowSum;
        for (int i = k; i < s.length(); i++) {
            // Subtract the vowel that is leaving the window
            if (isVowel(s.charAt(i - k))) {
                windowSum -= 1;
            }
            // Add the vowel that is entering the window
            if (isVowel(s.charAt(i))) {
                windowSum += 1;
            }
            // Update the maximum vowel count
            maxVowels = Math.max(maxVowels, windowSum);
        }
        return maxVowels;
    }
}
