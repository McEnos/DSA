package com.company.leetcode.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 215. Kth Largest Element in an Array
 */
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    private static int solution(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
