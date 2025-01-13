package com.company.leetcode;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(solution(27));
    }

    private static int solution(int n) {
        int low = 1;
        int high = n / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int square = mid * mid;
            if (square == n) {
                return mid;
            } else if (square < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
