package com.company.v3.stack;

public interface Stack<T> {
    T peek() throws Exception;

    T pop() throws Exception;

    void push(T element) throws Exception;

    boolean isEmpty();

    int size();

}
