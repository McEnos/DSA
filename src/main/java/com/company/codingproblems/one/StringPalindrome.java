package com.company.codingproblems.one;

public class StringPalindrome {
    public static void main(String[] args) {

    }

    private static boolean solution(String value) {
        StringBuilder sb = new StringBuilder();
        return sb.append(value).reverse().toString().equals(value);
    }

    private static boolean solutionV2(String value) {
        int left = 0;
        int right = value.length() - 1;
        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
