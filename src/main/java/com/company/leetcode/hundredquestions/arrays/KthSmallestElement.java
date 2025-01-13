package com.company.leetcode.hundredquestions.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    public static void main(String[] args) {

    }

    private static int solution(int[] nums, int k) {
        // Max-Heap using a lambda for the Comparator
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Process each element in the array
        for (int num : nums) {
            maxHeap.add(num);
            // If the heap size exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // The root of the heap is the kth smallest element
        return maxHeap.peek();
    }

    private static int solutionV2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }
}
