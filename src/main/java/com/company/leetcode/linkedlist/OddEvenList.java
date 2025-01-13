package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 328. Odd Even Linked List
 */
public class OddEvenList {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (Objects.isNull(head) || head.next == null) {
            return head; //Edge case: if the list has 0 or 1 node, no reordering needed
        }
        ListNode odd = head; //start with the head(odd
        ListNode even = head.next; //Start with the second node(even)
        ListNode evenHead = even;  //Save the head of the even list

        while (Objects.nonNull(even) && Objects.nonNull(even.next)) {
            //Connect current odd to the next odd node
            odd.next = even.next;
            odd = odd.next;
            //Connect current even node to the next even node
            even.next = odd.next;
            even = even.next;
        }
        //Connect the end of the odd list to the head of the even list
        odd.next = evenHead;
        return head; // The head of the rearranged list
    }
}
