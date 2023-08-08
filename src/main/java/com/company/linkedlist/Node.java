package com.company.linkedlist;

public class Node<T>  {

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getValue() {
        return data;
    }

    public void setValue(T value) {
        this.data = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
