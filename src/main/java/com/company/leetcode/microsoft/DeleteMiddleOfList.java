package com.company.leetcode.microsoft;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class DeleteMiddleOfList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevNode = null;
        //When fast reaches the end of the list, slow will be in the middle
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }
}
