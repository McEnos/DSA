package com.company.v3;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;

    LinkedList() {
        head = null;
    }

    LinkedList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (!Objects.isNull(head)) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void deleteHead() {
        if (Objects.isNull(head))
            return;
        head = head.getNext();
    }

    public void deleteTail() {
        Node<T> previous = null;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext())) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        previous.setNext(null);
    }
    public void deleteAtPosition(int position){
        if (Objects.isNull(head))
            return;
        if (Objects.equals(position,0)){
            head = head.getNext();
        }
        Node<T> previous = null;
        Node<T> currentNode = head;
        int currentPosition = 0;
        while (Objects.nonNull(currentNode.getNext()) && currentPosition < position - 1){
            currentPosition += 1;
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        previous.setNext(currentNode.getNext());
    }

    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (Objects.isNull(head)) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (Objects.nonNull(currentNode.getNext())) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public void insertAtPosition(int position, T data) {
        if (position == 0) {
            this.insertHead(data);
        } else {
            Node<T> newNode = new Node<>(data);
            int currentPosition = 0;
            Node<T> currentNode = head;
            while (Objects.nonNull(currentNode.getNext()) && currentPosition < position - 1) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }

    public int listLengthRecursive(Node<T> head) {
        if (Objects.isNull(head))
            return 0;
        return 1 + listLengthRecursive(head.getNext());
    }

    public int listLength(Node<T> head) {
        int count = 0;
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            count += 1;
            currentNode = currentNode.getNext();
        }
        return count;
    }
}
