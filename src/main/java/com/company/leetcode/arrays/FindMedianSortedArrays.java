package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/?envType=problem-list-v2&envId=array
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(solution(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    private static double solution(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;
        int[] mergedArray = new int[length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }
        double median;
        boolean evenLength = length % 2 == 0;
        if (evenLength) {
            int maxIndex = length / 2;
            int minIndex = (length / 2) - 1;
            median = (mergedArray[maxIndex] + mergedArray[minIndex]) / 2.0;
        } else {
            median = mergedArray[length / 2];
        }
        return median;
    }
}
