package com.company.leetcode.linkedlist;

import com.company.leetcode.models.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/?envType=problem-list-v2&envId=et00a8d3
 */
public class DetectCycle {
    public static void main(String[] args) {

    }

    private static ListNode solution(ListNode head) {
         //use tortoise & hare algorithm
        ListNode tortoise = head;
        ListNode hare = head;
        boolean loopExists = false;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            //when both of them meets simply break;
            if (tortoise == hare) {
                loopExists = true;
                break;
            }
        }
         //Now bring back the slow to head of the linked list and traverse it until   fast==slow
        //If a cycle is detected, leave slow pointer at place of collision with
        //fast; start a new pointer from head of list and step both head pointer
        //and slow by one until collision => this is the origin of the cycle.
        if (loopExists) {
            tortoise = head;
            while (tortoise != hare) {
                tortoise = tortoise.next;
                hare = hare.next;
            }
            //This is the starting of the Loop
            return tortoise;
        }
        return null;
    }
}
