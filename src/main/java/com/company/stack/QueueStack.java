package com.company.stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack<T> implements Stack<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public QueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Empty stack");
        return q1.remove();
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return q1.peek();
    }

    @Override
    public int size() {
        return q1.size();
    }

    @Override
    public void push(T data) throws Exception {
        q2.add(data);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
