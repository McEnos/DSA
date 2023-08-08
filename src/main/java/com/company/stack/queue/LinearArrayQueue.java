package com.company.stack.queue;

public class LinearArrayQueue<T> implements Queue<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private Object[] queue;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public LinearArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public LinearArrayQueue(int capacity) {
        this.queue = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(T data) {
        rear += 1;
        queue[rear] = data;
        size += 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        T element = (T) queue[front];
        queue[front] = null;
        front += 1;
        size -= 1;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return (T) queue[front];
    }
}
