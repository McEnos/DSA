package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-list/
 * 148. Sort List
 */
public class SortList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode current = head;
        while (current != null) {
            minHeap.add(current);
            current = current.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
        }
        /**
         * When you rebuild the sorted linked list by polling nodes from the priority queue, each node retains its original next reference.
         * If tail.next = null is not included at the end, the last node in your new list might still point to an old part of the original list,
         * resulting in an improperly terminated list.
         * this may result to infinite loop
         */
        tail.next = null;
        return dummy.next;
    }

    private static ListNode solutionV2(ListNode head) {
        if (head == null || head.next == null) return head; //Base case, the list is already sorted
        // 1. Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two halves

        // 2. Recursively sort both halves

        ListNode sortedLeft = solutionV2(left);
        ListNode sortedRight = solutionV2(right);
        return merge(sortedLeft, sortedRight);
    }

    /**
     * When finding the middle node, there are things to be taken note of
     * 1) if we start fast as fast = head:
     * If the list has odd length, this approach will return the exact middle node.
     * For an even-length list, the slow pointer will point to the second of the two middle nodes.
     * 2) if we start fast as fast = head.next
     * For odd-length lists, it returns the middle node.
     * For even-length lists, it returns the first of the two middle nodes.
     * If you need the first middle node for even-length lists, use Approach 2 (fast = head.next).
     * If you need the second middle node for even-length lists, use Approach 1 (fast = head).
     */

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        /**
         * From above explanation
         *  When sorting the list with merge sort, we split the list into two halves. For this, it’s better to return
         *  the first middle node (Approach 2) because:
         *  The second half starts from the node after the first middle node.
         *  This avoids including the middle node in both halves.
         */
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }
}

