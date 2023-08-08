package com.company.stack.queue;

public class CircularArrayQueue<T> implements Queue<T> {
    private Object[] queue;
    private final static int DEFAULT_CAPACITY = 10;
    int front;
    int rear;

    int size;

    CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    CircularArrayQueue(int capacity) {
        this.queue = new Object[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) {
            resizeArray();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size += 1;
    }

    private void resizeArray() {
        int newCapacity = queue.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(queue, front, newArray, 0, size);
        queue = newArray;
        front = 0;
        rear = size - 1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        T element = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size += 1;
        return element;
    }

    private boolean isFull() {
        return size == queue.length;
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
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return null;
    }
}
