package com.company.searchingAndSorting;

import java.util.Arrays;

/**
 * Selection sort is a simple comparison-based sorting algorithm. It divides the input list into two parts:
 * the sublist of items already sorted, which is built up from left to right,
 * and the sublist of items remaining to be sorted that occupy the rest of the list.
 * Initially, the sorted sublist is empty, and the unsorted sublist is the entire input list.
 * The algorithm proceeds by finding the smallest element in the unsorted sublist,
 * exchanging it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 2, 4, 7})));
    }

    /**
     * One by one move the boundary of the unsorted subarray
     * Outer loop to place the correct element at index i
     * Find the minimum element in the unsorted array
     * <p>
     * Inner loop to find the true minimum element in the unsorted part
     * Traverse the unsorted subarray
     * If the current element is smaller, update minIdx
     */
    private static int[] solution(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; //Assume the current index is the minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update minIndex if a smaller element is found
                }
            }
            // Swap the found minimum element with the first element of the unsorted subarray
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
