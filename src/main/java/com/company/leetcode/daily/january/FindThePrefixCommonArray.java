package com.company.leetcode.daily.january;

import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArray {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        //Loop through each index to calculate common element for each prefix
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            int commonCount = 0;
            //Compare elements in A and B within the range of current prefix
            for (int aIndex = 0; aIndex <= currentIndex; aIndex++) {
                for (int bIndex = 0; bIndex <= currentIndex; bIndex++) {
                    //Check if elements match, and count if any do
                    if (A[aIndex] == B[bIndex]) {
                        commonCount++;
                        break; //prevent counting duplicates
                    }
                }
            }
            // Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }
        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }

    private static int[] solutionV2(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];

        //Initialize sets to store elements from A and B
        Set<Integer> elementsInA = new HashSet<>();
        Set<Integer> elementsInB = new HashSet<>();

        //Iterate through the elements of both arrays;
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            //Add current elements from A and B to respective sets.
            elementsInA.add(A[currentIndex]);
            elementsInB.add(B[currentIndex]);

            int commonCount = 0;
            //Count common elements between the sets
            for (int element : elementsInA) {
                if (elementsInB.contains(element)) {
                    commonCount++;
                }
            }
            //Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }
        return prefixCommonArray;
    }

}
