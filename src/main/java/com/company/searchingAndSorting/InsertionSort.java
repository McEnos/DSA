package com.company.searchingAndSorting;

import java.util.Arrays;

/**
 * Insertion Sort is a simple comparison-based sorting algorithm where the array is virtually split into a sorted and an unsorted part.
 * The algorithm works by picking elements one by one from the unsorted part and inserting them into their correct position in the sorted part.
 * <p>
 * Start with the first element (consider it as the sorted part).
 * Pick the next element and compare it with the elements in the sorted part.
 * Shift the elements in the sorted part (if needed) to the right to create a position for the new element.
 * Insert the new element in the correct position.
 * Repeat the process until the entire array is sorted.
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 2, 4, 7})));
    }

    private static int[] solution(int[] arr) {
        int n = arr.length;
        // Start with the second element (index 1) since the first element is trivially sorted
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Store the current element to be inserted
            int j = i - 1;
            //Shift elements of arr[0...i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element to the right
                j--; // Move to the previous element
            }
            arr[j + 1] = key; // Insert the key at the correct position
        }
        return arr;
    }

}
