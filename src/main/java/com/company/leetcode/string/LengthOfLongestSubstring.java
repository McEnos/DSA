package com.company.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=string
 * 3 Longest SubString without repeating Characters
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    private static int solution(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
