package com.company.leetcode.daily.january;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bitwise-xor-of-all-pairings
 * https://algo.monster/liteproblems/2425
 */
public class XorAllNums {
    public static void main(String[] args) {

    }
    private static int solution(int[] nums1, int[] nums2) {
        int result = 0;
        // If the length of nums2 is odd, XOR result with all elements in nums1
        // Because if nums2 has an odd number of elements,
        // each element in nums1 will be represented an odd number of times when taking
        // the XOR with all elements of nums2 and vice versa.
        if (nums2.length % 2 == 1) {
            for (int num : nums1) {
                result ^= num;
            }
        }
        // Likewise, if the length of nums1 is odd, XOR result with all elements in nums2
        if (nums1.length % 2 == 1) {
            for (int num : nums2) {
                result ^= num;
            }
        }
        return result;
    }

    private static int solutionV2(int[] num1, int[] num2) {
        //Get lengths of the arrays
        int len1 = num1.length;
        int len2 = num2.length;

        //Map to store frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();

        //Add frequencies for num1 elements, each element appears n2 times int the final result
        for (int num : num1) {
            freq.put(num, freq.getOrDefault(num, 0) + len2);
        }

        //Add frequencies for num2 elements, each element appears n1 times in the final result
        for (int num : num2) {
            freq.put(num, freq.getOrDefault(num, 0) + len1);
        }

        // XOR numbers that appear odd number of times
        int ans = 0;
        for (int num : freq.keySet()) {
            if (freq.get(num) % 2 == 1) {
                ans ^= num;
            }
        }

        return ans;
    }


}
