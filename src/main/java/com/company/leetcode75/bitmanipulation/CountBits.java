package com.company.leetcode75.bitmanipulation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2)));
        System.out.println(Arrays.toString(solution(5)));
    }

    private static int[] solution(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
