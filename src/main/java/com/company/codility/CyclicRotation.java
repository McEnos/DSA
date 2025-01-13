package com.company.codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }

    private static int[] solution(int[] A, int k) {
        int n = A.length;
        // Handle edge cases: empty array or no rotations needed
        if (n == 0 || k % n == 0) {
            return A;
        }
        // Optimize K using modulo to avoid redundant rotations
        /**
         * If K > N, we only need to perform K % N rotations, since rotating by the array length gives the same result as the original array.
         */
        k = k % n;
        // Create a new array to hold the rotated result
        int[] rotatedArray = new int[n];
        // Copy the last K elements to the front of the new array
        /**
         * public static void arraycopy(
         *     Object src,      // The source array from which elements will be copied.
         *     int srcPos,      // The index in the source array where copying starts.
         *     Object dest,     // The destination array where elements will be copied.
         *     int destPos,     // The starting index in the destination array where elements will be placed.
         *     int length       // Number of elements to copy
         * )
         */
        System.arraycopy(A, n - k, rotatedArray, 0, k);
        // Copy the first N - K elements to the remaining positions
        System.arraycopy(A, 0, rotatedArray, k, n - k);
        return rotatedArray;
    }
}
