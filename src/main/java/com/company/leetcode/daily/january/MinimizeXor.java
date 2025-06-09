package com.company.leetcode.daily.january;

/**
 * https://algo.monster/liteproblems/2429
 * https://leetcode.com/problems/minimize-xor/description
 */
public class MinimizeXor {
    public static void main(String[] args) {

    }

    private static int solution(int num1, int num2) {
        //count the number of 1-bits(set bits) in both num1 and num2
        int count1 = Integer.bitCount(num1);
        int count2 = Integer.bitCount(num2);

        //if count1 is greater than count2, we need to turn off some 1-bits in num1
        while (count1 > count2) {
            //Turn off(unset) the rightmost 1-bit in num1
            num1 &= (num1 - 1);
            //Decrement count1 as we have reduced the number of 1-bits by one
            count1--;
        }
        //If count1 is less than count2, we need to turn on(set) additional 1-bits in num1
        while (count1 < count2) {
            // Turn on(set) the rightmost 0-bit in num1
            num1 |= (num1 + 1);
            //increment count1 as we have increased the number of 1-bits bt one
            count1++;
        }
        // After the adjustments, num1 should have the same number of 1-bits as num2,
        // and this is the minimized XOR value we are looking for
        return num1;
    }

    private static int solutionV2(int num1, int num2) {
        //Initialize result to num1, we will modify the result
        int result = num1;
        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);
        // Start with the least significant bit(bit 0).
        int currentBit = 0;

        //Add bits to result if it has fewer set bits than the target
        while (setBitsCount < targetSetBitsCount) {
            //if the current bit in result is not set (0), set it to 1
            if (!isSet(result, currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            //Move to the next bit
            currentBit++;
        }
        //Remove bits from result if it has more set bits than the target
        while (setBitsCount > targetSetBitsCount) {
            //if the current bit int result is set(1), unset it (make it 0)
            if (isSet(result, currentBit)) {
                result = unsetBit(result, currentBit);
                setBitsCount--;
            }
            //Move to the next bit
            currentBit++;
        }

        return result;
    }

    //Helper function to check if the given bit position in result is set (1)
    private static boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    //Helper function to set the given bit position in result to 1
    private static int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    //Helper function to unset the given bit position int x (set it to 0)
    private static int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }


}
