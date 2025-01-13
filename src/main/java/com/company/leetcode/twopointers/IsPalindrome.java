package com.company.leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * 125 Valid Palindrome
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }

    private static boolean solution(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                list.add(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
