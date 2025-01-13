package com.company.leetcode.monotonicstack;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/solutions/5852947/monotonic-stack-intuition-approach
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1})));
    }

    private static int[] solution(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % size] >= stack.peek()) {
                stack.pop();
            }
            if (i < size) {
                int nextLargest = stack.isEmpty() ? -1 : stack.peek();
                result[i] = nextLargest;
            }
            stack.push(nums[i % size]);
        }
        return result;
    }
}
