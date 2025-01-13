package com.company.leetcode.stack;

import java.util.Stack;

/**
 * Infix to Postfix conversion is essential for evaluating mathematical expressions efficiently,
 * as postfix (or Reverse Polish Notation, RPN) removes the need for parentheses and operator precedence during evaluation
 */
public class InfixToPostfix {
    public static void main(String[] args) {

    }

    private static String solution(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            // If the character is an operand, add it to the result
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
            // If the character is '(', push it onto the stack
            else if (c == '(') {
                stack.push('(');
            } else if (c == ')') { //if it is ), pop until (
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // Pop '(' to remove it
            }// If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    //check associativity
                    if (!isRightAssociative(c) || precedence(stack.peek()) > precedence(c)) {
                        sb.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(c);  // Push the current operator
            }
        }
        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static boolean isRightAssociative(char operator) {
        return operator == '^';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
