package com.company.leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    public static void main(String[] args) {

    }

    private static boolean solution(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);
        return Arrays.equals(aCharArray, bCharArray);
    }
}
