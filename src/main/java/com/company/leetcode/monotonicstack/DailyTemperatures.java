package com.company.leetcode.monotonicstack;

/**
 * Monotonic Stacks:
 * A monotonic stack is a type of stack data structure that maintains its elements in a monotonically increasing or decreasing order.
 * It is commonly used to solve problems involving comparisons between elements (like finding the next greater or smaller element) in linear time.
 * <p>
 * Monotonically Increasing Stack: Elements in the stack are stored in increasing order from bottom to top.
 * This means each new element is smaller than the element below it. It is useful for finding the next smaller element to the right or left.
 * <p>
 * Monotonically Decreasing Stack: Elements are stored in decreasing order from bottom to top,
 * meaning each new element is greater than the one below it. This type is useful for finding the next greater element
 */

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75
 * 739. Daily Temperatures
 */
public class DailyTemperatures {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //popping all the indexes with lower or equal temperature of the current index
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            //if the stack still has elements, then a warmer day exists.
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            //Insert the current index into the stack
            stack.push(i);

        }
        return result;
    }
}
