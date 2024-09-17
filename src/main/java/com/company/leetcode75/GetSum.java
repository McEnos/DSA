package com.company.leetcode75;

/**
 * https://leetcode.com/problems/sum-of-two-integers/description/
 * https://leetcode.com/problems/sum-of-two-integers/solutions/500457/detailed-explanation-bit-manipulation-and-binary-arithmetic-java-code
 */
public class GetSum {
    public static void main(String[] args) {
        System.out.println(solution(2,4));
    }

    private static int solution(int a, int b) {
        while (b != 0) {
            int carry = a & b; // 1. Calculate the carry
            a = a ^ b; // 2. Calculate the sum without carry
            b = carry << 1; // 3. Shift the carry
        }
        return a;  // 4. Final result when carry becomes 0
    }
}
