package com.company.stack.queue;

import java.util.Stack;

public class StackQueue<T> implements Queue<T> {
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public StackQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }


    @Override
    public void enqueue(T data) {
        enqueueStack.push(data);
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    @Override
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    @Override
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }
}
