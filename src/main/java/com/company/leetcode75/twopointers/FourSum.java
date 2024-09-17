package com.company.leetcode75.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(solution(new int[]{2,2,2,2,2},8));
    }

    private static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array
        Arrays.sort(nums);
        // Step 2: Iterate with two nested loops for the first two numbers
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // Step 3: Use two pointers to find the remaining two numbers
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // We found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + i]) {
                            left++;
                        }
                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // Move both pointers
                        left++;
                        right--;
                    } else if (sum < target) {  // If the sum is less than target, move the left pointer to increase the sum
                        left++;
                    } else {
                        right--;// If the sum is greater than target, move the right pointer to decrease the sum
                    }
                }
            }

        }
        return result;
    }
}
