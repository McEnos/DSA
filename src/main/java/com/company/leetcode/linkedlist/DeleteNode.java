package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 237. Delete a node in a linked list
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    private void solution(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        /**
         * Copy the value from the next node into the current node.
         * This way, the current node will have the same value as the next node.
         *
         * Skip the next node by adjusting the next pointer of the current node to point to the node after the next.
         * Effectively, the next node is deleted because there is no reference to it anymore.
         */
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
