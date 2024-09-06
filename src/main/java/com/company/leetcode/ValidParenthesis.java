package com.company.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(solution("()"));
        System.out.println(solution("()[]{}"));
        System.out.println(solution("(]"));
        System.out.println(solution("([])"));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) { // assuming the provided string only has parenthesis
            return false;
        }
        for (char c : s.toCharArray()) {
            if (openingParenthesis(c)) {
                stack.push(c);
            } else if (closingParenthesis(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topCharacter = stack.peek();
                if (isMatching(topCharacter, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean closingParenthesis(char s) {
        return Arrays.asList(')', ']', '}').contains(s);
    }

    private static boolean openingParenthesis(char s) {
        return Arrays.asList('(', '[', '{').contains(s);
    }

    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']');
    }


}
