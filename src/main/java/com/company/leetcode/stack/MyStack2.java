package com.company.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    /**
     * Every time we push an element, it is first added to the queue (q.offer(x)).
     * We then rotate the queue by dequeuing all the other elements and enqueuing them back (q.offer(q.poll()))
     * so the newly added element ends up at the front of the queue, just like the top of a stack.
     */
    public void push(int x) {
        // Enqueue the new element
        queue.offer(x);
        // Rotate the queue to move the new element to the front
        int size = queue.size();
        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }

    }

    /**
     * The most recently added element is always at the front of the queue because of how the push() operation was designed.
     * To pop the top of the stack, we simply dequeue the front element (q.poll()).
     */
    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();  // Dequeue the front element, which is the "top" of the stack
    }

    public int top() {
        return queue.peek();  // Peek the front element
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
