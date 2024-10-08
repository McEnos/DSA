package com.company.v3;

public class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.setData(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
