package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 */
public class CheckZeroOnes {
    public static void main(String[] args) {
        System.out.println(solution("1101"));
        System.out.println(solution("111000"));
        System.out.println(solution("110100010"));
    }

    private static boolean solution(String s) {
        int ones = countOnes(s);
        int zeros = countZeros(s);
        return ones > zeros;
    }

    private static boolean solutionV2(String s) {
        int currentOnes = 0;
        int currentZeros = 0;
        int maxOnes = 0;
        int maxZeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentOnes++;
                maxZeros = Math.max(maxZeros, currentZeros);
                currentZeros = 0;
            } else {
                maxOnes = Math.max(maxOnes, currentOnes);
                currentOnes = 0;
                currentZeros++;
            }
        }
        maxZeros = Math.max(maxZeros, currentZeros);
        maxOnes = Math.max(maxOnes, currentOnes);
        return maxOnes > maxZeros;
    }

    private static int countOnes(String s) {
        int currentOnes = 0;
        int maxOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentOnes++;
            } else {
                maxOnes = Math.max(maxOnes, currentOnes);
                currentOnes = 0;
            }
        }
        return Math.max(maxOnes, currentOnes);
    }

    private static int countZeros(String s) {
        int currentZeros = 0;
        int maxZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                currentZeros++;
            } else {
                maxZeros = Math.max(maxZeros, currentZeros);
                currentZeros = 0;
            }
        }
        return Math.max(maxZeros, currentZeros);
    }
}
