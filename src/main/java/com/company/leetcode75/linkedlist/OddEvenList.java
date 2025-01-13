package com.company.leetcode75.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class OddEvenList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head; // Pointer for odd-indexed nodes
        ListNode even = head.next;  // Pointer for even-indexed nodes
        ListNode evenHead = even;  // Head of even-indexed nodes

        while (even != null && even.next != null) {
            odd.next = even.next;  // Link to the next odd node
            odd = odd.next;  // Move odd pointer
            even.next = odd.next;   // Link to the next even node
            even = even.next;  // Move even pointer
        }
        odd.next = evenHead;  // Concatenate even list after odd list
        return head;

    }
}
