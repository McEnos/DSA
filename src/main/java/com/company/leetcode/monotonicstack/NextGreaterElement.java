package com.company.leetcode.monotonicstack;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/solutions/5852815/3ms-intuition-approach-monotonic-stack
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    private static int[] solution(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&  nums2[i] > stack.peek()) {
                stack.pop();
            }
            int value = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], value);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    /**
     * General Next largest element concept
     */
    private int[] solution2(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
