package com.company.leetcode75;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/5604903/find-the-greatest-common-divisor-of-strings
 * To find the GCD of two strings, we can leverage the properties of string repetition.
 * If two strings have a common divisor string, then concatenating the two strings in any order should yield the same result.
 * This gives us a quick way to check if a common divisor string exists.
 * If they can be concatenated in any order to produce the same string, the length of the GCD string will be the GCD of the lengths of the two strings.
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(solution("ABCABC","ABC"));
        System.out.println(solution("ABABAB","ABAB"));
        System.out.println(solution("LEET","CODE"));
    }

    public static String solution(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        //ABCABCABC
        //ABCABCABC
        //ABABABABAB
        //ABABABABAB
       // "hamburger".substring(4, 8) returns "urge" "smiles".substring(1, 5) returns "mile"
        return str1.substring(0,gcdLength);


    }

    /**
     * Euclidean algorithm
     * GCD of 2 number also divides their differences
     * 1) Divide the larger number by the smaller number
     * 2) Record the remainder
     * 3) Replace the larger number with the smaller number and smaller number with the remainder
     * 4) Repeat the process until the remainder is Zero, the last Non-Zero remainder is the GCD
     *
     */

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
