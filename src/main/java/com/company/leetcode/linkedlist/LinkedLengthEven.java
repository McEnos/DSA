package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * Take a pointer that moves at 2x [two nodes at a time]. At the end, if
 * the length is even, then the pointer will be NULL; otherwise it will point to the last node.
 */
public class LinkedLengthEven {
    public static void main(String[] args) {

    }

    private static boolean solution(ListNode head) {
        if (head == null) return false;
        while (Objects.nonNull(head) && Objects.nonNull(head.next)) {
            head = head.next.next;
        }
        return head == null;
    }
}
