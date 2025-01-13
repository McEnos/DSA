package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 21 Merge 2 Sorted Lists
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;
        // Traverse both lists and append the smaller node to the merged list
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1; // Append the smaller node
                head1 = head1.next; // Move the pointer
            } else {
                curr.next = head2;  // Append the smaller node
                head2 = head2.next;  // Move the pointer
            }
            curr = curr.next; // Move to the next node in the merged list
        }
        // Append any remaining nodes from either list
        if (head1 != null){
            curr.next = head1;  // Append remaining nodes from list1
        }else{
            curr.next = head2;  // Append remaining nodes from list2
        }
        return dummy.next; // Return the merged list, skipping the dummy node
    }
}
