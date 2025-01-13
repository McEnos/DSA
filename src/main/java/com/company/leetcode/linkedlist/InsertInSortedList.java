package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

public class InsertInSortedList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head, ListNode node) {
        if (head == null) {
            return node;
        }
        ListNode current = head;
        while (current != null && current.val < node.val) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;

        return head;
    }
}
