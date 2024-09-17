package com.company.leetcode.stack;


import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(solution("3[a]2[bc]"));
        System.out.println(solution("3[a2[c]]"));
        System.out.println(solution("2[abc]3[cd]ef"));
    }

    private static String solution(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number for k
                k = k * 10 + c - '0';
            } else if (c == '[') {
                // Push the current number and string to their respective stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the next part of the string
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop the last multiplier and string from the stack
                int currentK = countStack.pop();
                StringBuilder decodeString = stringStack.pop();
                // Append the repeated substring to the decoded string
                for (int i = 0; i < currentK; i++) {
                    decodeString.append(currentString);
                }
                currentString = decodeString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
