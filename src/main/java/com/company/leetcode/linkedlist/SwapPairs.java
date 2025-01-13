package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 24 Swap Nodes in pairs
 */
public class SwapPairs {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        // Dummy node to simplify the swapping process
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Iterate through the list in pairs
        while (current.next != null && current.next.next != null) {
            ListNode firstNode = current.next; // First node of the pair
            ListNode secondNode = current.next.next; // Second node of the pair

            // Swapping the nodes
            firstNode.next = secondNode.next; // Link first node to the next pair
            secondNode.next = firstNode;  // Link second node to the first node
            current.next = secondNode;   // Link current to the second node
            // Move the current pointer two nodes ahead
            current = firstNode; // current is now pointing to the first node
        }
        return dummy.next; // Return the new head, which is dummy.next

    }
}
