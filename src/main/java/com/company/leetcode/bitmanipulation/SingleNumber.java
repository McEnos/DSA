package com.company.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/single-number/description/?envType=problem-list-v2&envId=bit-manipulation
 * 136 Single Number
 *
 * Time Complexity: O(n) – We traverse the array once.
 * Space Complexity: O(1) – No extra space is used (only one variable result).
 *
 * Properties of XOR:
 *  XORing a number with itself results in 0.  a ^ a = 0
 *  XORing a number with 0 results in the number itself.  a ^ 0 = a
 *  XOR is commutative and associative: The order of XOR operations doesn’t matter. a ^ b ^ a = b
 *
 *  All duplicate elements cancel out to 0 using the a ^ a = 0 property.
 *  Only the non-duplicate element (4) is left in the final result because a ^ 0 = a ensures the initial value (0) doesn’t affect the calculation.
 *  The order doesn’t matter (thanks to commutativity and associativity), so we can XOR the numbers sequentially as they appear in the array.
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 4, 1, 2, 9, 1, 4, 2 }));
    }

    private static int solution(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
