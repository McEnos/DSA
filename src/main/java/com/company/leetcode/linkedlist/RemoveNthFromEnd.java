package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 19. Remove Nth Node From End of List
 */

/**
 * NB: when removing nth node from the end we use while(fast.next != null
 * and use while(fast != null) when finding nth node from the end
 * <p>
 * When you're only finding the nth node from the end, you want to stop exactly at that node. Here's a typical code structure:
 * Condition: while (first != null) ensures the traversal ends exactly when first reaches the end of the list.
 * <p>
 * When removing the nth node from the end, you need to stop at the node right before the one you want to delete. Here's the usual structure:
 * Condition: while (first.next != null) ensures that we stop one step before the end of the list (i.e., the last node).
 * Why? Because you need the previous node (i.e., second pointer) to adjust its next pointer and skip the nth node.
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (Objects.isNull(fast.next)) {
                if (i == n - 1) {
                    head = head.next;
                }
                return head;
            }
            fast = fast.next;

        }
        // Loop until we reach to the end.
        // Now we will move both fast and slow pointers
        while (Objects.nonNull(fast.next)) {
            fast = fast.next;
            slow = slow.next;
        }
        // Delink the nth node from last
        if (Objects.nonNull(slow.next)) {
            slow.next = slow.next.next;
        }
        return head;
    }
    /**
     * Preferred solution
     */
    private static ListNode solutionV3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * Preferred solution
     */

    private static ListNode solutionV2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Move the `fast` pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (Objects.isNull(fast)) { // If n > length of list, return original head
                return head;
            }
            fast = fast.next;
        }
        // If `fast` is null, it means we need to remove the head node
        if (Objects.isNull(fast)) {
            return head.next;
        }
        // Move both `fast` and `slow` until `fast` reaches the end
        while (Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next;
        }
        // Remove the nth node from the end by skipping it
        slow.next = slow.next.next;
        return head;
    }

    private static ListNode nthNodeFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode current = head;
        int index = 0;
        while (current != null) {
            map.put(index, current);
            current = current.next;
            index++;
        }
        int length = index;// Total number of nodes
        int targetIndex = length - n; // Index of the nth node from the end

        if (targetIndex < 0) return null;

        return map.get(targetIndex);
    }

    private static ListNode nthNodeFromEndV2(ListNode head, int n) {
        if (head == null || n <= 0) return null;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        int targetIndex = length - n;
        if (targetIndex < 0) return null;
        int index = 0;
        current = head;
        while (index < targetIndex) {
            current = current.next;
            index++;
        }
        return current;
    }


    private static ListNode findNthNodeFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Move the 'fast' pointer n steps ahead
        for (int i = 0; i < n; i++) {
            // n is larger than the length of the list(If first becomes null during this phase, it means the list is shorter than n nodes.)
            if (fast == null) return null;
            fast = fast.next;
        }
        while (Objects.nonNull(fast)) {  // Move both pointers until 'fast' reaches the end
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
