package com.company.searchingAndSorting;


import java.util.Arrays;

/**
 * Using two pointers
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution(new int[]{-1,0}, -1)));
    }

    public static int[] solution(int[] a, int target) {
        int lowest = 0;
        int highest = a.length - 1;
        while (lowest < highest) {
            int sum = a[lowest] + a[highest];
            if (sum < target) {
                lowest++;
            } else if (sum > target) {
                highest--;
            } else {
                return new int[]{lowest+1, highest+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
