package com.company.stack;

import com.company.linkedlist.LinkedList;
import com.company.linkedlist.Node;

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedListStack(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T data) {
        this.list.insertAtBeginning(data);
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        Node<T> head = this.list.head;
        this.list.deleteFirstNode();
        return head.getValue();
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return this.list.head.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.list.head == null;
    }

    @Override
    public int size() {
        return list.listLength(list.head);
    }
}
