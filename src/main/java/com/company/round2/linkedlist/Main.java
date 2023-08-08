package com.company.round2.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Node<Integer> nodeOne = new Node<>(1);
        Node<Integer> nodeTwo = new Node<>(2);
        Node<Integer> nodeThree = new Node<>(3);
        Node<Integer> nodeFour = new Node<>(4);
        nodeOne.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);
        LinkedList<Integer> list = new LinkedList<>(nodeOne);
        list.insertAtEnd(5);
        list.insertAtBeginning(0);
        list.insertAfter(nodeOne, 12);
        list.insertAtPosition(2, 0);
        list.printList(nodeOne);
        System.out.println();
        System.out.println(list.listLength(nodeOne));

        System.out.println("After reversal");
        Node<Integer> node = list.reverseLinkedList(nodeOne);
        list.head = node;
        list.printList(nodeOne);


    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int bestSum = 0;
        for (int i : nums) {
            currentSum = Math.max(0, currentSum + 1);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }


}
