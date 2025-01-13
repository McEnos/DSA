package com.company.leetcode.stack;

public class DynamicArrayStack<T> implements Stack<T> {
    private int top;
    private Object[] stack;

    private static final int CAPACITY = 10;
    private int capacity;

    public DynamicArrayStack() {
        this(CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        stack = new Object[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    private boolean threeQuarterEmpty() {
        int length = size();
        int threeQuarterCapacity = (3 * capacity) / 4;
        return length == threeQuarterCapacity;
    }

    private void shrink() {
        int length = size() / 2;
        Object[] newStack = new Object[length];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity = length;
    }

    private void expand() {
        int length = size();
        Object[] newStack = new Object[length * 2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity = capacity * 2;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            expand();
        }
        stack[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (isEmpty()) throw new Exception("Stack is empty");
        return (T) stack[top];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (isEmpty()) throw new Exception("Stack is empty");
        T element = (T) stack[top];
        stack[top--] = null;
        if (threeQuarterEmpty()) {
            shrink();
        }
        return element;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
