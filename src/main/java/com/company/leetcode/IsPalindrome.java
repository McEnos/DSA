package com.company.leetcode;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    private static boolean solution(int number) {
        if (number < 0) {
            return false;
        }
        int reversed = reverse(number);
        return number == reversed;
    }

    private static int reverse(int value) {
        int reverse = 0;
        while (value > 0) {
            reverse = reverse * 10 + value % 10;
            value = value / 10;
        }
        return reverse;
    }

    private static boolean solutionV2(int value) {
        String stringValue = String.valueOf(value);
        int left = 0;
        int right = stringValue.length() - 1;
        while (left < right) {
            if (stringValue.charAt(left) != stringValue.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
