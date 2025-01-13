package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 * 2095: Delete the middle node of a linked list
 */
public class DeleteMiddle {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        //using two pointers(slow & fast) when fast reach the end, slow will be in the middle.
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //skip the middle node(deleting it)
        prev.next = prev.next.next;
        return head;
    }
}
