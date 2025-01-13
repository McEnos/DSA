package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    private static boolean solution2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static ListNode findStartOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean loopExists = false;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    private static int findLengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean loopExists = false;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            do {
                fast = fast.next;
                length++;
            } while (fast != slow);
        }
        return length;
    }
}
