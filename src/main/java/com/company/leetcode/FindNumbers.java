package com.company.leetcode;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class FindNumbers {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            int digits = numberOfDigits(num);
            if (isEvent(digits)) {
                evenCount++;
            }
        }
        return evenCount;
    }

    private static boolean isEvent(int num) {
        return num % 2 == 0;
    }

    /**
     * * This line divides num by 10 and assigns the result back to num.
     * *  In integer division, dividing by 10 effectively removes the last digit of the number.
     * For example:
     * *  If num is 123, after num / 10, it becomes 12.
     * *  If num is 12, after num / 10, it becomes 1.
     * *  If num is 1, after num / 10, it becomes 0.
     */
    private static int numberOfDigits(int num) {
        if (num == 0) {
            return 1;
        }
        num = Math.abs(num);
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;

    }

}
