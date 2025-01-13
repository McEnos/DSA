package com.company.leetcode.leetcode75.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1379473350/
 * https://algo.monster/liteproblems/3
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    private static int solution(String s) {
        int maxLength = 0;
        int left = 0;
        // Use a HashSet to store the characters in the current window without duplicates
        Set<Character> set = new HashSet<>();
        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right); // Current character at the right pointer

            // If currentChar is already in the set, it means we have found a repeating character
            // We slide the left pointer of the window to the right until the duplicate is removed
            while (set.contains(current)) {
                set.remove(s.charAt(left++));
            }
            // Add the current character to the set as it is now unique in the current window
            set.add(current);
            // Calculate the length of the current window (rightPointer - leftPointer + 1)
            // Update the maxLength if the current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
