package com.company.leetcode75.twopointers;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=two-pointers
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(solution("sadbutsad", "sad"));
        System.out.println(solution("leetcode", "leeto"));
    }

    private static int solution(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
