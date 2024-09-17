package com.company.v3.stack;

public class DynamicArrayStack<T> implements Stack<T> {
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    private int top;

    private Object[] stack;

    DynamicArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
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
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        T element = (T) stack[top];
        stack[++top] = null;
        if (threeQuarterEmpty()) {
            shrink();
        }
        return element;
    }

    @Override
    public void push(T element) throws Exception {
        if (isFull()) {
            resize();
        }
        stack[++top] = element;

    }

    private boolean threeQuarterEmpty() {
        int length = size();
        int threeQuarterCapacity = (capacity * 3) / 4;
        return length <= threeQuarterCapacity;
    }

    private boolean isFull() {
        return size() == capacity;
    }

    private void shrink() {
        int length = size() / 2;
        Object[] newStack = new Object[length];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity = length;
    }

    private void resize() {
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
    public int size() {
        return top + 1;
    }
}
