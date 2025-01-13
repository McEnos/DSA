package com.company.leetcode.queue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 232. Implement Queue using Stacks
 */
public class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        // If both stacks are empty, the queue is empty
        if (input.isEmpty() && output.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // If output is empty, move elements from input to output
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // The top of stack2 is the front of the queue
        return output.pop();
    }

    public int peek() {
        // If both stacks are empty, the queue is empty
        if (input.isEmpty() && output.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // If stack2 is empty, move elements from stack1 to stack2
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // The top of stack2 is the front of the queue
        return output.peek();

    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}
