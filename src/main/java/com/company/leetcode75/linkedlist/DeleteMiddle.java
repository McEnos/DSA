package com.company.leetcode75.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/605598948/?envType=study-plan-v2&envId=leetcode-75
 */
public class DeleteMiddle {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode preNode = null;
        //using two pointers(slow & fast) when fast reach the end, slow will be in the middle.
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            preNode = slowPointer;
            slowPointer = slowPointer.next;
        }
        //skip the middle node(deleting it)
        preNode.next = preNode.next.next;
        return head;

    }

  /*  private static ListNode solution(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode previousNode = null;

        while (Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
            fastPointer = fastPointer.next;
            previousNode = slowPointer;
            slowPointer = slowPointer.next;
        }
        previousNode.next = previousNode.next.next;
        return head;
    }*/
}
