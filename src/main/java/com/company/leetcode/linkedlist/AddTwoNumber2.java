package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * 445 add two numbers 2
 */
public class AddTwoNumber2 {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        // Push all nodes of l1 onto stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        // Push all nodes of l2 onto stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null; // Head of the resulting linked list
        // Add digits from both stacks until both are empty
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            carry = sum / 10; // Update carry
            int digit = sum % 10;
            // Create a new node with the sum's last digit
            ListNode newNode = new ListNode(digit);
            // Insert the new node at the front of the result list
            newNode.next = result;
            result = newNode;
        }
        return result;

    }
}
