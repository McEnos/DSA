package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 * 143: Reorder List
 */
public class ReorderList {
    public static void main(String[] args) {

    }

    private static void solution(ListNode head) {
        if (head == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Cut off the first half

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
