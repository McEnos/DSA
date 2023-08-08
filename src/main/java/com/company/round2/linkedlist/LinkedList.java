package com.company.round2.linkedlist;

import java.util.Objects;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList() {
        this.head = null;
    }

    public int listLengthIterative(Node<T> head) {
        int length = 0;
        Node<T> current = head;
        while (Objects.nonNull(current)) {
            current = current.getNext();
            length += 1;
        }
        return length;
    }

    public int listLengthRecursive(Node<T> head) {
        if (Objects.isNull(head))
            return 0;
        return 1 + listLengthRecursive(head.getNext());
    }

    public void insertAtBeginning(T data) {
        System.out.println(this.head.getData());
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        System.out.println("New head"+ this.head.getData());
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        while (Objects.nonNull(current.getNext())) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void deleteFirstNode() {
        this.head = this.head.getNext();
    }

    public void deleteLastNode() {
        Node<T> current = head;
        Node<T> prevNode = null;
        while (Objects.nonNull(current.getNext())) {
            prevNode = current;
            current = current.getNext();
        }
        prevNode.setNext(null);
        current = null;
    }

    public void deleteAtPosition(int position) {
        if (Objects.isNull(head))
            return;
        Node<T> currentNode = head;
        if (Objects.equals(0, position)) {
            this.head = currentNode.getNext();
            return;
        }
        int currentPos = 0;
        Node<T> prevNode = null;
        while (Objects.nonNull(currentNode) && currentPos < position) {
            prevNode = currentNode;
            currentPos += 1;
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext());

    }

    public void insertAfter(Node<T> prevNode, T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
    }

    public void insertAtPosition(int position, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        int currentPosition = 0;
        while (Objects.nonNull(currentNode.getNext()) && currentPosition < position - 1) {
            currentPosition += 1;
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);

    }

    public Node<T> reverseLinkedList(Node<T> head) {
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;

        }
        head = prevNode;
        return head;

    }

    public Node<T> middleNode(Node<T> head) {
        Node<T> slowPointer = head;
        Node<T> fastPointer = head;
        while (Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.getNext())) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }
        return slowPointer;
    }

    public int listLength(Node<T> head) {
        Node<T> currentNode = head;
        int count = 0;
        while (Objects.nonNull(currentNode)) {
            count += 1;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public void printList(Node<T> head){
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)){
            System.out.print(currentNode.getData() + " -->");
            currentNode = currentNode.getNext();
        }
    }
}
