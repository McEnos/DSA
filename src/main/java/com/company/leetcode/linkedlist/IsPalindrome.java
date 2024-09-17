package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=et00a8d3
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }

    private static boolean solution(ListNode head) {
        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static boolean solution2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
