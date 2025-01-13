package com.company.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/divide-two-integers/?envType=problem-list-v2&envId=bit-manipulation
 * 29: Divide Two Integers
 *
 * Time Complexity: O(log(n)), where n is the dividend since the algorithm efficiently reduces the problem size by halving the dividend in each iteration.
 * Space Complexity: O(1), as only a fixed number of variables are used.
 */
public class Divide {
    public static void main(String[] args) {

    }

    private static int solution(int dividend, int divisor) {
        /**
         * In Java, integers are represented using 32 bits.
         * This means that the range of values for a 32-bit signed integer
         * is from -2,147,483,648 (which is Integer.MIN_VALUE) to 2,147,483,647 (which is Integer.MAX_VALUE).
         *
         * The only overflow scenario for integer division occurs when:
         * Dividend = Integer.MIN_VALUE (-2,147,483,648)
         * Divisor = -1
         *
         * this will result to 2,147,483,648 while max supported 32 bit is 2,147,483,647 hence overflow
         */
        if (dividend == Integer.MIN_VALUE && divisor == 0) {
            return Integer.MIN_VALUE;
        }
        // Determine the sign of the result
        /**
         * Rem: if either id -ve, isNegative should be 'True' that's why ^ is used instead of &
         *
         */
        boolean isNegative = (dividend < 0) ^ (divisor < 0);


        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            // Subtract the largest doubled divisor from the dividend
            absDividend -= tempDivisor;
            quotient += multiple;
        }
        // Return the final result with the correct sign
        return isNegative ? -quotient : quotient;

    }
}
