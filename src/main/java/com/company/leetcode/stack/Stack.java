package com.company.leetcode.stack;

public interface Stack<T> {
    public boolean isEmpty();

    public int size();

    public void push(T item);

    public T pop() throws Exception;

    public T peek() throws Exception;

    public boolean isFull();
}
