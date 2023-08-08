package com.company.stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private int capacity;
    public static final int CAPACITY = 10;

    private Object[] stack;

    private int top;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new Object[capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("LinkedListStack is empty");
        T element = (T) stack[top];
        stack[top--] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return (T)stack[top];
    }

    @Override
    public void push(Object data) throws Exception {
        if (this.size() == capacity) {
            throw new Exception("Stack is full");
        }
        stack[++top] = data;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(stack, 0, newArray, 0, capacity);
        stack = newArray;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "capacity=" + capacity +
                ", stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }
}
