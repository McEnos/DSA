package com.company.leetcode75.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window&
 */
public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("abcagcbb"));
    }

    private static int solution(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int maxSubStringLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxSubStringLength = Math.max(maxSubStringLength, right - left + 1);
        }
        return maxSubStringLength;
    }

}
