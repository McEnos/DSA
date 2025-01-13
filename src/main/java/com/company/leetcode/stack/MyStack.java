package com.company.leetcode.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * <p>
 * https://www.youtube.com/watch?v=Eh2gTUHL8Hs
 * <p>
 * In the alternative approach, we make the pop operation costly while keeping the push operation O(1).
 * This means that during the push() operation, elements are simply enqueued into one of the queues.
 * During the pop() operation, we transfer all elements except the last one from the main queue to the auxiliary queue, then return (or pop) the last element.
 */
public class MyStack {
    SortedSet<Integer> stack = new TreeSet<Integer>();
    Deque<Integer> deque = new ArrayDeque<>();
    List<Integer> list = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }

    // Push element x onto stack
    public void push(int x) {
        q1.offer(x); // Simply enqueue into q1
    }

    // Removes the element on top of the stack and returns that element

    /**
     * Dequeue all elements from q1 except the last one, and enqueue them into q2.
     * The last dequeued element is the top element of the stack (which is to be popped).
     * NB: Swap the names of q1 and q2 so that q1 always holds the current stack elements.
     */
    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Empty Stack");
        }
        // Transfer all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        // The last element left in q1 is the top of the stack
        int topElement = q1.poll();

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topElement;

    }

    /**
     * Similar to the pop() operation, but instead of removing the last element, it is just returned.
     */
    public int top() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Empty Stack");
        }
        // Transfer all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        // The last element left in q1 is the top of the stack
        int topElement = q1.peek();

        // Move the last element to q2 (to preserve stack state)
        q2.offer(q1.poll());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
