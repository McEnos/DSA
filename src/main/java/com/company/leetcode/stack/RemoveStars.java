package com.company.leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
 * Loop through the string, if a non-star character is encountered, push it to the stack, otherwise(character is a star), pop the
 * top most character from the stack(this is the nearest non-star character)
 * This process should continue as long as there are stars in the provided string.
 * <p>
 * if the stack is still having data, as long as the stack is not empty, create a string from the content by appending each popped character
 * to StringBuilder
 * <p>
 * reverse the StringBuilder object to get the original String.
 */
public class RemoveStars {
    public static void main(String[] args) {
        System.out.println(solution("leet**cod*e"));
        System.out.println(solution("erase*****"));
    }

    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * Optimized version to use O(n) memory for StringBuilder if there are no * character
     *
     * @param s
     * @return
     */
    private static String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
