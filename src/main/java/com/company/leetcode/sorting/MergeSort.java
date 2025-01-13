package com.company.leetcode.sorting;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-an-array/?envType=problem-list-v2&envId=merge-sort
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5,1,1,2,0,0})));
    }

    private static int[] solution(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);

        }
        return nums;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = nums[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            nums[k++] = leftArray[i++];
        }
        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}
