package com.company.leetcode75.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        // Initialize prevNode to null (which will be the new tail) and currentNode to head
        ListNode prevNode = null;
        ListNode currentNode = head;
        // Traverse the list until currentNode is null
        while (Objects.nonNull(currentNode)) {
            // Store the next node before breaking the link
            ListNode nextNode = currentNode.next;
            // Reverse the current node's link
            currentNode.next = prevNode;
            // Move prevNode and currentNode one step forward
            prevNode = currentNode;
            currentNode = nextNode;
        }
        // Return the new head of the reversed list (prevNode)
        return prevNode;
    }
}
