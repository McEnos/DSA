package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

public class PrintListFromEnd {
    public static void main(String[] args) {

    }

    private static void solution(ListNode head) {
        if (head == null) return;
        solution(head.next);
        System.out.println(head.val);
    }
}
