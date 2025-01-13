package com.company.leetcode;

/**
 * Using two pointers
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
