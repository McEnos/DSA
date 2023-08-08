package com.company.stack.queue;

import com.company.linkedlist.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList<T> list;

    public LinkedListQueue(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(Object data) {
        this.list.insertAtEnd((T) data);
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Empty queue");
        T element = list.head.getValue();
        list.deleteFirstNode();
        return element;
    }

    @Override
    public int size() {
        return list.listLength(list.head);
    }

    @Override
    public boolean isEmpty() {
        return this.list.head == null;
    }

    @Override
    public T peek() {
        return list.head.getValue();
    }
}
