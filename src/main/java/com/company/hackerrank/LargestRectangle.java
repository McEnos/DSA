package com.company.hackerrank;

import java.util.List;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 */
public class LargestRectangle {
    public static void main(String[] args) {

    }

    private static long solution(List<Integer> h) {
        long maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = h.size();
        // Traverse through each bar in the histogram
        for (int i = 0; i < n; i++) {
            // While the current bar is smaller than the bar at the stack's top, calculate the area
            while (!stack.isEmpty() && h.get(stack.peek()) >= h.get(i)) {
                int height = h.get(stack.pop());
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long currentArea = (long) height * width;
                maxArea = Math.max(maxArea, currentArea);
            }
            // Push the current bar index onto the stack
            stack.push(i);
        }
        // Compute area for remaining bars in the stack
        while(!stack.isEmpty()){
            int height = h.get(stack.pop());
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) width * height);
        }
        return maxArea;
    }

}
