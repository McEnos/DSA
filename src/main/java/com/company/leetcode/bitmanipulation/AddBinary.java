package com.company.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/add-binary/?envType=problem-list-v2&envId=bit-manipulation
 * 67 Add Binary
 * https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
 */
public class AddBinary {
    public static void main(String[] args) {

    }

    private static String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            // Compute the new bit and the carry
            int currentBit = sum % 2;
            sb.append(currentBit);
            carry = sum / 2;

        }
        return sb.reverse().toString();
    }
}
