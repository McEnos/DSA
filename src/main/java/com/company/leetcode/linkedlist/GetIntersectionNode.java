package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/?envType=problem-list-v2&envId=et00a8d3
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        if (set.isEmpty()) {
            return null;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
