package com.company.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/?envType=problem-list-v2&envId=array
 * https://leetcode.com/problems/plus-one/solutions/2706861/java-fastest-0ms-runtime-easy-and-elegant-solution
 */
public class PlusOne {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(solution(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{9,9,9,9})));
    }

    private static int[] solution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;


    }


}
