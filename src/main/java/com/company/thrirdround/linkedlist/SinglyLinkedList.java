package com.company.thrirdround.linkedlist;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (!Objects.isNull(head)) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position > listLength(head))
            throw new IllegalArgumentException("Invalid position");
        if (head == null)
            return;
        if (position == 0) {
            head = head.getNext();
            return;
        }
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        int currentPosition = 0;
        while (Objects.nonNull(currentNode) && currentPosition < position) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentPosition += 1;
        }
        prevNode.setNext(currentNode.getNext());
    }

    public void insertAtPosition(int position, T data) {
        if (position < 0 || position > listLength(head)) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            insertHead(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        int currentPosition = 0;
        while (Objects.nonNull(currentNode) && currentPosition < position) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentPosition += 1;
        }
        newNode.setNext(currentNode);
        prevNode.setNext(newNode);
    }

    public void insertAfter(T prevData, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> prevNode = findNode(prevData);
        if (Objects.nonNull(prevNode)) {
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
    }
//TODO: research on how to reverse a linked list
    public Node<T> reverseList(Node<T> head){
        Node<T> prevNode = null; // This pointer will be used to keep track of the previous node
        Node<T> currentNode = Objects.nonNull(head) ? head : this.head; // This pointer starts at the head of the original linked list
        Node<T> nextNode = null;  // This pointer will be used to temporarily store the next node in the original list
        // Traverse the linked list
        while(Objects.nonNull(currentNode)){
            nextNode = currentNode.getNext(); // Save the next node in the original list
            currentNode.setNext(prevNode); // Reverse the link by pointing the current node's next to the previous node
            prevNode = currentNode;  // Move the pointers one step forward in the linked list
            currentNode = nextNode;
        }
       // this.head =  prevNode;// After the traversal, update the head to the last node, which is now the first node in the reversed list
        return prevNode;
    }


    private Node<T> findNode(T data) {
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            if (currentNode.getData().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head; //to prevent head from being modified, we use a new variable
        while (Objects.nonNull(currentNode.getNext())) {
            currentNode = currentNode.getNext(); //traverse to the last node
        }
        currentNode.setNext(newNode);
    }

    public void deleteFirstNode() {
        head = head.getNext();
    }

    public void deleteLastNode() {
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        while (Objects.nonNull(currentNode.getNext())) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        prevNode.setNext(null);
    }

    public int listLength(Node<T> head) {
        int length = 0;
        Node<T> currentNode = Objects.nonNull(head) ? head : this.head;
        while (Objects.nonNull(currentNode)) {
            length += 1;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public void display() {
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            System.out.print(currentNode.getData() + " -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }


}
