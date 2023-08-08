package com.company.stack;

public interface Stack<T> {
    boolean isEmpty();


    T pop() throws Exception;

    T peek() throws Exception;

    int size();

    void push(T data) throws Exception;
}
