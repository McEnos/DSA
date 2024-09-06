package com.company.searchingAndSorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 2, 4, 7})));
    }

    /**
     * this algorithm can be optimized by checking if a swap happened, if swap never happened, it means the list
     * is already sorted
     * i.e  It can be optimized by stopping the algorithm if the inner loop didn’t cause any swap.
     */
    private static int[] solution(int[] a) {
        int n = a.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
