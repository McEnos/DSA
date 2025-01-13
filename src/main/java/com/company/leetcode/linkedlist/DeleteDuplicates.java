package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/614367999/
 * 83. Remove Duplicates from a Sorted List
 */
public class DeleteDuplicates {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prevNode = head;
        while (prevNode.next != null) {
            if (prevNode.val == prevNode.next.val) {
                prevNode.next = prevNode.next.next;
            } else {
                prevNode = prevNode.next;
            }
        }
        return head;
    }

    private static ListNode solutionV2(ListNode head) {
        if (head == null || head.next == null) return head;
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode current = head;
        ListNode next;
        while (current.next != null) {
            next = current.next;
            if (map.containsKey(current.val)) {
                current.next = current.next.next;
            } else {
                map.put(current.val, true);
            }
        }
        return null;
    }
}
