package com.company.thrirdround.linkedlist;

public class Main {
    public static void main(String[] args) {
        Node<Integer> firstNode = new Node<>(1);
/*        Node<Integer> secondNode = new Node<>(2);
        Node<Integer> thirdNode = new Node<>(3);
        Node<Integer> fourthNode = new Node<>(4);
        Node<Integer> fifthNode = new Node<>(5);*/
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(firstNode);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        list.insertTail(5);
        list.insertHead(0);
        list.insertTail(6);
        list.insertTail(7);
        System.out.println("Before deletion");
        list.display();
        System.out.println("After deletion");
        list.insertAtPosition(2, 10);
        // list.deleteFirstNode();
        //list.deleteLastNode();
        //list.deleteAtPosition(7);
        list.display();
        list.reverseList(null);
        System.out.println("After reversal");
        list.display();
    }

}
