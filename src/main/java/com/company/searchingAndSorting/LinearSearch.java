package com.company.searchingAndSorting;

public class LinearSearch {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
