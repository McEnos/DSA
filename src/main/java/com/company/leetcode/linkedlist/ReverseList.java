package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while (Objects.nonNull(currNode)) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}
