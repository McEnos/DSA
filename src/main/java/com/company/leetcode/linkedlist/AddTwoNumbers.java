package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 2 Add Two numbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result building.
        ListNode current = dummy; // Pointer to build the result list.
        int carry = 0;  // Initialize carry to 0.

        // Loop until both lists are exhausted and carry is 0.
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous iteration.

            // Add values from both lists if present.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Compute the new digit and update the carry.
            carry = sum / 10;
            int digit = sum % 10;

            // Add the digit to the result list.
            current.next = new ListNode(digit);
            current = current.next;


        }
        return dummy.next; // Return the next of dummy node, which is the result head.
    }

    private static ListNode solutionV2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
