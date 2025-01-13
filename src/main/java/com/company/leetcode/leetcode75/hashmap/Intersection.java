package com.company.leetcode.leetcode75.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 * https://algo.monster/liteproblems/2248
 */
public class Intersection {
    public static void main(String[] args) {

    }

    private static List<Integer> solution(int[][] nums) {
        // Array to store the count of each element (assuming the range of elements is 0-1000)
        int[] count = new int[1001];
        // Iterate through each sub-array
        for (int[] array : nums) {
            // Count each element in the sub-array
            for (int element : array) {
                count[element]++;
            }
        }
        // List to store the result (elements present in all sub-arrays)
        List<Integer> result = new ArrayList<>();
        // Iterate through the count array to find elements with a count equal to the number of arrays,
        // which means they appear in every sub-array.
        for (int i = 0; i < 1001; i++) {
            if (count[i] == nums.length) {
                result.add(i); // Add to the result list if element is present in all arrays
            }
        }

        return result;
    }
}
