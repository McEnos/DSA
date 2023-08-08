package com.company.stack.queue;

public interface Queue<T> {
    void enqueue(T data);
    T dequeue() throws Exception;

    int size();
    boolean isEmpty();
    T peek() throws Exception;
}
