package com.company.leetcode.leetcode75;

/**
 * https://algo.monster/liteproblems/1071
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class GcdOfStrings {
    public static void main(String[] args) {

    }

    private static String solution(String s1, String s2) {
        if (!(s1 + s2).equals(s2 + s1)) {
            return "";
        }
        int gcdLength = gcd(s1.length(), s2.length());
        return s1.substring(0, gcdLength);

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
