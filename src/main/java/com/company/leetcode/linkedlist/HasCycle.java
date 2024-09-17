package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=et00a8d3
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    private static boolean solution(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();
        while (head != null) {
            if (nodeSeen.contains(head)) {
                return true;
            } else {
                nodeSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
