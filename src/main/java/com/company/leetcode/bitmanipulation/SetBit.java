package com.company.leetcode.bitmanipulation;

public class SetBit {
    public static void main(String[] args) {

    }

    private static int solution(int N, int bitPosition) {

        /**
         * Identify the Bit Position: Decide which bit you want to set.(bitPosition)
         * Create a Mask: Use 1 << bitPosition to create a mask that has a 1 at the desired position()
         * A mask is a number that has a 1 at the position of the bit you want to set and 0s elsewhere.
         *      You can create a mask by left-shifting 1 by n positions: 1 << n.
         */
        int mask = 1 << bitPosition;
        //Perform the OR Operation: Use number | mask to set the bit.
        return N | mask;

    }
}
