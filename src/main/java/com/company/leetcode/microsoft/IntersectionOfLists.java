package com.company.leetcode.microsoft;

import com.company.leetcode.models.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionOfLists {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode headA, ListNode headB) {
        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return null;
        }
        Set<ListNode> seenNodes = new HashSet<>();
        while (Objects.nonNull(headA)) {
            seenNodes.add(headA);
            headA = headA.next;
        }
        while (Objects.nonNull(headB)) {
            if (seenNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
