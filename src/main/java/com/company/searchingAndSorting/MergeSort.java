package com.company.searchingAndSorting;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-an-array/?envType=problem-list-v2&envId=merge-sort
 */
public class MergeSort {
    public static void main(String[] args) {
        //   System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 2, 4, 7}, 0, 5)));
        System.out.println(Arrays.toString(solution(new int[]{12, 11, 13, 5, 6, 7}, 0, 5)));
    }

    private static int[] solution(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            solution(arr, left, mid);
            solution(arr, mid + 1, right);
            // Merge the sorted halves
            merge(arr, left, mid, right);

        }
        return arr;
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        //Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        //Merge the temporary arrays
        // Initial indices of sub  arrays
        int i = 0;
        int j = 0;
        // Initial index of the merged subarray
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        //Copy remaining elements of rightArray
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        System.out.println("Merged array from index " + left + " to " + right + ":");
        System.out.println(Arrays.toString(arr));


    }
}
