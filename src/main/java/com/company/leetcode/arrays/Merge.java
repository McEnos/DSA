package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=problem-list-v2&envId=array
 * <p>
 * https://leetcode.com/problems/merge-sorted-array/solutions/5840919/don-t-miss-out-the-100-beats-solution-with-proper-explanation-in-java
 */
public class Merge {
    public static void main(String[] args) {

    }

    private static void solution(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for the last elements of nums1 and nums2
        int i = m - 1; // Pointer for the last valid element in nums1 (ignores trailing zeros)
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last position in nums1 (end of the array)
        // Merge nums1 and nums2 from the end to the beginning to avoid overwriting elements in nums1
        while (i >= 0 && j >= 0) { // Continue until one of the arrays is exhausted
            // If the current element in nums1 is larger, place it at the end of nums1  Place nums1[i] at index k and  Move pointer i one step to the left
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                // If the current element in nums2 is larger or equal, place it at the end of nums1  Place nums2[j] at index k and Move pointer j one step to the left
                nums1[k--] = nums2[j--];
            }
        }
        // If there are remaining elements in nums2, copy them into nums1
        // No need to copy elements from nums1, as they are already in place
        while (j >= 0) {
            nums1[k--] = nums2[j--];  // Copy remaining elements from nums2 into nums1 and  Move both j and K one step to the left
        }
    }

}
