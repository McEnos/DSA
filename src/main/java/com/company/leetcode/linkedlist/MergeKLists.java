package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23: Merge K sorted lists
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to keep track of the smallest node among all lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);// Comparator for sorting nodes by their value

        // Add the head of each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0); // Dummy node to simplify list construction
        ListNode current = dummy;

        // While the heap is not empty, extract the smallest element
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();  // Get the smallest node
            current.next = minNode;  // Add it to the merged list
            current = current.next;
            // If the extracted node has a next node, add it to the heap
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }

        }
        return dummy.next;  // Return the merged list (ignoring the dummy node)


    }

    private static ListNode solutionV2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode list : lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }
        return dummy.next;
    }
}
