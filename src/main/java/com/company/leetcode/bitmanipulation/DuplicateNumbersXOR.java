package com.company.leetcode.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/
 * 3158 Find the XOR of Numbers which appear twice
 */
public class DuplicateNumbersXOR {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        //count the occurrence of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        //XOR all the numbers that appear twice
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == 2) {
                result ^= key;
            }
        }
        return result;
    }
}
