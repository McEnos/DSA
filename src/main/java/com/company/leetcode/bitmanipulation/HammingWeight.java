package com.company.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class HammingWeight {
    public static void main(String[] args) {

    }

    private static int solution(int n) {
        int result = 0;
        // Note this operation removes "ONE" set bit (the least most significant) from the give number
        // so repeating this operation will eventually lead to n=0 and return the count
        while (n > 0) {
            result += 1;
            n = n & (n - 1);
        }
        return result;
    }
}
