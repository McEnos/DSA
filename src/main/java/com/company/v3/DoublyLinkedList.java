package com.company.v3;

import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> previous;
    private Node<T> next;

    DoublyLinkedList() {
        head = null;
        this.next = null;
        this.previous = null;
    }

    DoublyLinkedList(Node<T> head) {
        this.head = head;
        this.next = null;
        this.previous = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (Objects.isNull(head)) {
            head = newNode;
        }
        head = newNode;
    }
    public void insertAtPosition(int position, T data){
        if (position == 0){
            insertHead(data);
        }
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;
        int currentPosition = 0;
        while (Objects.nonNull(currentNode.getNext()) && currentPosition < position - 1 ){
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);

    }

    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (Objects.isNull(head)) {
            insertHead(data);
        }
        Node<T> currentNode = head;
        while (Objects.nonNull(currentNode.getNext())) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
    }

}
