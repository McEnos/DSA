package com.company.v3.stack;

public class ArrayStack<T> implements Stack<T> {
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] stack;
    private int top;

    ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    ArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.stack = new Object[capacity];
    }


    @Override
    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return (T) stack[top];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        T element = (T) stack[top];
        stack[top--] = null;
        return element;
    }

    @Override
    public void push(T element) throws Exception {
        if (isFull()) throw new Exception("Stack is full");
        stack[++top] = element;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
