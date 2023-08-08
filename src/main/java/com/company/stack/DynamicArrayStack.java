package com.company.stack;

import java.util.Arrays;

public class DynamicArrayStack<T> implements Stack<T>{
    private int capacity; //Total number of elements an array has potential of holding
    private final static int CAPACITY = 10;
    private Object[] stack;
    private int top;

    public DynamicArrayStack() {
        this(CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new Object[capacity];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * The actual number of elements that are currently held by an array
     */
    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("LinkedListStack is empty");
        return (T) stack[top];
    }

    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Empty stack");
        T element = (T) stack[top];
        stack[top--] = null;
        if (threeQuarterEmpty())
            shrink();
        return element;
    }

    public void push(Object data) {
        if (isFull())
            expand();
        stack[++top] = data;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    private void expand() {
        int length = size();
        Object[] newStack = new Object[length * 2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity = capacity * 2;
    }

    /**
     * Checks if current array is 3/4 empty
     */
    private boolean threeQuarterEmpty() {
        int length = size();
        int threeQuarterCapacity = (3 * capacity) / 4;
        return length <= threeQuarterCapacity;
    }

    private void shrink() {
        int newSize = size() / 2;
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, size());
        stack = newStack;
        capacity = newSize;
    }

    @Override
    public String toString() {
        return "DynamicArrayStack{" +
                "capacity=" + capacity +
                ", stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }
}
