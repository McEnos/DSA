package com.company.leetcode.hundredquestions.arrays;


import java.util.Arrays;

//https://www.geeksforgeeks.org/program-to-reverse-an-array/
public class ReverseArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }

    /**
     * Two pointer technique
     * Time(O(n)) Iterating through the list
     * Space O(1) No additional space
     */
    private static int[] solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    /**
     * Time(O(n)) Iterating through the list
     * Space O(n) No additional space
     */
    private static int[] solution2(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[n - i - 1];
        }
        System.arraycopy(temp, 0, nums, 0, n);
        return nums;
    }

    private static int[] solution3(int[] nums) {
        int n = nums.length;
        // Iterate over the first half and for every index i,
        // swap arr[i] with arr[n - i - 1]
        for (int i = 0; i < n / 2; i++) {
            int indexToSwap = n - i - 1;
            int temp = nums[i];
            nums[i] = nums[indexToSwap];
            nums[indexToSwap] = temp;
        }
        return nums;
    }
}
