package com.company.leetcode75.binarysearch;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75
 */
public class GuessNumber {
    public static void main(String[] args) {

    }

    private static int solution(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == -1) {
                high = mid - 1;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                return mid;
            }

        }
        return 0;
    }

    private static int guess(int n) {
        int guess = 0;
        if (n > guess) {
            return -1;
        } else if (n < guess) {
            return 1;
        }
        return 0;
    }
}
