package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(solution("()"));
        System.out.println(solution("()[]{}"));
        System.out.println(solution("(]"));
        System.out.println(solution("([])"));
    }

    private static boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpeningParenthesis(c)) {
                stack.push(c);
            } else if (isClosingParenthesis(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.peek();
                if (isMatching(top, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }


    private static boolean isOpeningParenthesis(char c) {
        return Arrays.asList('{', '[', '(').contains(c);
    }

    private static boolean isClosingParenthesis(char c) {
        return Arrays.asList(')', ']', '}').contains(c);
    }
}
