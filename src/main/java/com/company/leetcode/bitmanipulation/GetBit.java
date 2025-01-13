package com.company.leetcode.bitmanipulation;

/**
 * Getting a bit means retrieving the value of a specific bit in a binary representation of a number.
 * This operation helps determine whether a particular bit is set (1) or not set (0)
 *
 * When you want to get or check the value of a bit at a specific position n in a number,
 * you typically use a combination of the bitwise AND operation and a mask.
 */
public class GetBit {
    public static void main(String[] args) {

    }

    private static boolean solution(int N, int bitPosition){
        /**
         * Create a mask that has a 1 at the position of the bit you want to check and 0s elsewhere.
         * This can be done by left-shifting 1 by n positions: 1 << n.
         *
         * Use the bitwise AND (&) between your number and the mask.
         * If the result is non-zero, the bit is set (1). If the result is zero, the bit is not set (0).
         */
        int mask = 1 << bitPosition;
        return ((N & mask) != 0);

    }

}
