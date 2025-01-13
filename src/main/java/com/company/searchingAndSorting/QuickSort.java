package com.company.searchingAndSorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{12, 11, 13, 5, 6, 7}, 0, 5)));
    }

    private static int[] solution(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);

            // Recursively sort elements before and after partition
            solution(nums, low, pivotIndex - 1);
            solution(nums, pivotIndex + 1, high);
        }
        return nums;
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // Choosing the last element as pivot
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (nums[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(nums, i, j);
            }
        }
        // Swap arr[i + 1] and arr[high] (or pivot)
        swap(nums, i + 1, high);
        return i + 1; // Return the pivot index
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
