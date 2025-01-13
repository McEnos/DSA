package com.company.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/?envType=problem-list-v2&envId=bit-manipulation
 * 89 Gray Code
 * <p>
 * Gray Code is a binary numeral system where two consecutive numbers differ by exactly one bit.
 * The idea is to represent numbers in such a way that transitioning between successive numbers results in only one bit flip at a time.
 * n = 2 (2-bit Gray Code)
 * Gray Code sequence: [00, 01, 11, 10]
 *
 * Time Complexity: O(2^n) since we generate 2^n Gray code numbers.
 * Space Complexity: O(2^n) to store the result.
 */
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }

    private static List<Integer> solution(int n) {
        List<Integer> result = new ArrayList<>();
        int totalNumbers = 1 << n; // 2^n numbers
        for (int i = 0; i < totalNumbers; i++) {
            int nextNumber = (i ^ (i >> 1));//Gray code formula
            result.add(nextNumber);
        }
        return result;
    }

}
