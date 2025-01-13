package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/?envType=problem-list-v2&envId=et00a8d3
 * 160. Get Intersection of 2 Linked Lists
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

    private static ListNode solutionV2(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        // Traverse the lists. When a pointer reaches the end, switch it to the other list's head.
        while (ptrA != ptrB) {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        // Either both pointers meet at the intersection node, or both become null (no intersection).
        return ptrA;
    }
}
