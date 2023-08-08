package com.company.linkedlist;

import java.util.Objects;
import java.util.Stack;

public class LinkedList<T> {
    public Node<T> head;

    LinkedList(Node<T> head) {
        this.head = head;
    }

    LinkedList() {
        this.head = null;
    }

    public Node<T> insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (Objects.isNull(head)) {
            head = newNode;
        }
        newNode.setNext(head);
        head = newNode;
        return head;
    }

    public Node<T> insertTail(T data){
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext())){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        return head;
    }

    public int listLength(Node<T> head) {
        int length = 0;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            length += 1;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public int listLengthRecursive(Node<T> node) {
        if (Objects.isNull(node))
            return 0;
        return 1 + listLengthRecursive(node.getNext());
    }

    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        this.head = newNode;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext())) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
    }


    public void deleteFirstNode() {
        head = head.getNext();
    }

    public void deleteLastNode() {
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext())) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        prevNode.setNext(null);

    }

    public void deleteAtPosition(int position) {
        // list is empty, head will be null
        if (Objects.isNull(head))
            return;
        Node<T> currentNode = head;
        // position is 0, means delete head
        if (Objects.equals(position, 0)) {
            head = currentNode.getNext();
            return;
        }
        int currentPosition = 0;
        Node<T> prevNode = null;
        while (currentPosition < position) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentPosition += 1;
        }
        prevNode.setNext(currentNode.getNext());

      /*  if (Objects.isNull(head))
            return;

        Node<T> currentNode = head;
        if (Objects.equals(position, 0)) {
            head = currentNode.getNext();
            return;
        }
        for (int i = 0; Objects.nonNull(currentNode) && i < position - 1; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());*/


    }

    public void insertAfter(Node<T> prevNode, T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
    }

    public void insertAtPosition(int position, T data) {
        Node<T> newNode = new Node<>(data);
        int currentPosition = 0;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext()) && currentPosition < position - 1) {
            currentNode = currentNode.getNext();
            currentPosition += 1;
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    private boolean loopExists(Node<T> head) {
        Node<T> hare = head;
        Node<T> tortoise = head;
        while (Objects.nonNull(hare) && Objects.nonNull(hare.getNext())) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            if (Objects.equals(tortoise, hare))
                return true;
        }
        return false;

    }

    private Node<T> findLoopBeginning(Node<T> head) {
        Node<T> hare = head;
        Node<T> tortoise = head;
        boolean loopExists = false;
        while (Objects.nonNull(hare) && Objects.nonNull(hare.getNext())) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            if (Objects.equals(hare, tortoise)) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            tortoise = head;
            while (!Objects.equals(hare, tortoise)) {
                tortoise = tortoise.getNext();
                hare = hare.getNext();
            }
            return tortoise;
        } else {
            return null;
        }
    }

    private int findLengthOfLoop(Node<T> head) {
        Node<T> hare = head;
        Node<T> tortoise = head;
        boolean loopExists = false;
        while (Objects.nonNull(hare) && Objects.nonNull(hare.getNext())) {
            hare = hare.getNext().getNext();
            tortoise = tortoise.getNext();
            if (Objects.equals(tortoise, hare)) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            tortoise = head;
            while (!Objects.equals(hare, tortoise)) {
                hare = hare.getNext();
                tortoise = tortoise.getNext();
                length += 1;
            }
        }
        return length;
    }

    /*public Node<T> insertInSortedLIst(Node<T> head,T data){
        Node<T> newNode = new Node<>(data);
        if(Objects.isNull(head))
            return newNode;
        Node<T> currentNode = head;
        Node<T> temp = null;
        while (Objects.nonNull(currentNode) && currentNode < newNode){
            temp = currentNode;
            currentNode = currentNode.getNext();

        }
    }*/

    public Node<T> reverseLinkedList(Node<T> head) {
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while (Objects.nonNull(currentNode)) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    //Counting no of nodes in a circular linked list
    public int noOfNodes() {
        int length = 0;
        Node<T> currentNode = head;
        while (!Objects.equals(currentNode, head)) {
            length += 1;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    //code for counting nodes in circular linked list
    public int nodeCounterV1(Node<Integer> head) {
        int counter = 0;
        Node<Integer> next = head.getNext();
        while (!Objects.equals(next.getNext(), head)) {
            counter += 1;
            next = next.getNext();
        }
        // LinkedListQueue<String> queue = new java.util.LinkedList<>();
        Stack<String> stack = new Stack<>();


        //Integer.D

        return counter;
    }

}
