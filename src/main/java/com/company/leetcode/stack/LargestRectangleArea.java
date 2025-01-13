package com.company.leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 84. Largest Rectangle in Histogram
 */
public class LargestRectangleArea {
    public static void main(String[] args) {

    }

    private static int solution(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            // Use 0 height for the imaginary bar at the end
            int h = (i == n) ? 0 : heights[i];
            // While the current bar is shorter than the bar on top of the stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);

        }
        return maxArea;
    }

}
