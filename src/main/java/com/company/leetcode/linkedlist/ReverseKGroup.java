package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 25 Reverse Nodes in a K- group
 */
public class ReverseKGroup {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head, int k) {
        if (head == null || k == 1) return head;
        //We use a dummy node to handle edge cases where the head changes due to reversal.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the k-th node from the current position
            ListNode kthNode = kthNode(prevGroupEnd, k);
            if (kthNode == null) break; // Less than k nodes left
            // Save the start of the next group
            ListNode nextGroupStart = kthNode.next;

            // Reverse the current group
            ListNode prev = null;
            ListNode current = prevGroupEnd.next;
            while (current != nextGroupStart) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            // Connect the reversed group with the previous part
            //After reversing, we connect the current group with the previous group and move on to the next one.

            /**
             * //groupStart is the first node of the current group being reversed.
             * In the first iteration, prevGroupEnd is initially the dummy node, so prevGroupEnd.next points to the head of the original list.
             */
            ListNode groupStart = prevGroupEnd.next;

            /**
             * Connect the Previous Group to the Reversed Group:
             * After reversing the current group, the k-th node (which was the last node before reversal) becomes the new head of the reversed group.
             * We connect the end of the previous group (prevGroupEnd) to this new head (kthNode).
             */
            prevGroupEnd.next = kthNode;
            /**
             * Connect the Reversed Group to the Next Part of the List:
             * groupStart (which was the first node of the original group) is now at the end of the reversed group.
             * We need to connect it to the next group’s starting node, which is stored in nextGroupStart
             */
            groupStart.next = nextGroupStart;
            // Move the pointer to the end of the current group
            /**
             * Move the Pointer for the Next Iteration:
             * prevGroupEnd is now moved to the end of the current reversed group (which is groupStart).
             * This prepares prevGroupEnd to act as the connector for the next group in the next iteration.
             */
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

    //We use the getKthNode helper function to find the end of the current group.
    private static ListNode kthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}


