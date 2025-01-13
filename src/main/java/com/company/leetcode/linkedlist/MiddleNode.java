package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * 876 Middle of the Linked List
 */
public class MiddleNode {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
