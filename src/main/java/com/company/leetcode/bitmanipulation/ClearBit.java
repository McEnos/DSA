package com.company.leetcode.bitmanipulation;

/**
 * Clearing a bit means setting a specific bit in a binary representation of a number to 0.
 * https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/
 */
public class ClearBit {
    public static void main(String[] args) {

    }

    private static int solution(int N, int bitPosition) {
        /**
         * Create a Mask: The mask should have a 0 at the position you want to clear and 1s elsewhere.
         * This can be achieved by left shifting 1 by i positions and then negating it.
         * The tilde ~ operator is the bitwise NOT operator, which flips the bits.
         * Apply the AND Operation: Use the bitwise AND (&) operation between your number and the mask.
         */

        int mask = ~(1 << bitPosition);
        return N & mask;

    }
}
