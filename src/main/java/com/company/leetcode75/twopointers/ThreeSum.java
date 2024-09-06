package com.company.leetcode75.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=two-pointers&
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution(new int[]{0,1,1}));
    }

    private  static List<List<Integer>> solution(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            // Skip the same element to avoid duplicates
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int left = i + 1; // Pointer for the next element
            int right = a.length - 1;  // Pointer for the last element
            while (left < right) {
                // If we find a triplet
                int sum = a[i] + a[left] + a[right];
                if (sum == 0) {
                    result.add(Arrays.asList(a[i], a[left], a[right]));
                    // Move both pointers to skip duplicates
                    while (left < right && a[left] == a[left + 1]) {
                        left++;
                    }
                    while (left < right && a[right] == a[right - 1]) {
                        right--;
                    }
                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < 0) {  // If the sum is less than zero, move the left pointer to the right to increase the sum
                    left++;
                } else {  // If the sum is greater than zero, move the right pointer to the left to decrease the sum
                    right--;
                }
            }
        }
        return result;
    }
}
