package com.company.searchingAndSorting;

import java.util.Arrays;

/**
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the list,
 * compares adjacent elements, and swaps them if they are in the wrong order.
 * The process is repeated until the list is sorted.
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 2, 4, 7})));
        System.out.println(Arrays.toString(solutionV2(new int[]{1, 2, 1, 2, 4, 7})));
    }

    /**
     * Outer loop for multiple passes through the array
     * This loop runs n-1 times, representing the number of passes needed to ensure the array is sorted.
     * After each pass, the next largest element is correctly positioned at the end of the array.
     * <p>
     * <p>
     * Inner loop for comparing adjacent elements
     * This loop iterates through the unsorted portion of the array.
     * The - i part ensures that the inner loop does not consider the already sorted elements at the end of the array.
     */
    private static int[] solution(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            //Inner loop for comparing adjacent elements
            //This loop iterates through the unsorted portion of the array.
            //The - i part ensures that the inner loop does not consider the already sorted elements at the end of the array.
            for (int j = 0; j < n - i - 1; j++) {
                //If the current element is greater than the next element, swap them.
                //This ensures that the larger element bubbles up to its correct position.
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }
        }
        return arr;
    }

    /**
     * this algorithm can be optimized by checking if a swap happened, if swap never happened, it means the list
     * is already sorted
     * i.e  It can be optimized by stopping the algorithm if the inner loop didn’t cause any swap.
     */
    private static int[] solutionV2(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
