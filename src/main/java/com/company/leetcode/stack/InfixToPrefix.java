package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        System.out.println(solution("A + B * C - D ^ E ^ F"));
    }

    private static String solution(String expression) {
        String reversed = reverseTokens(expression);         // Step 1: Reverse the expression
        String replaced = replaceBrackets(reversed);   // Step 2: Replace brackets
        String postFix = infixToPostfix(replaced);     // Step 3: Convert to postfix
        return reverseTokens(postFix);                       // Step 4: Reverse postfix to get prefix
    }

    private static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);  // Append operands to result directly
            } else if (c == '(') {
                stack.push(c);  // Push '(' onto stack
            } else if (c == ')') {
                // Pop until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();  // Remove '(' from stack
            } else {
                // While top of stack has higher precedence or equal precedence (for left-associative)
                while (!stack.isEmpty() &&
                        (precedence(stack.peek()) > precedence(c) ||
                                (precedence(stack.peek()) == precedence(c) && !isRightAssociative(c)))) {
                    sb.append(stack.pop());
                }
                stack.push(c);  // Push current operator onto stack
            }
        }

        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // Reverse the expression by tokens rather than characters
    private static String reverseTokens(String expression) {
        String[] tokens = expression.split("\\s+");  // Split by spaces
        Collections.reverse(Arrays.asList(tokens));  // Reverse the token list
        return String.join(" ", tokens);             // Join tokens back into a string
    }


    // Replace '(' with ')' and vice versa
    private static String replaceBrackets(String expression) {
        return expression.replace('(', 'X')
                .replace(')', '(')
                .replace('X', ')');
    }

    // Check if operator is right-associative
    private static boolean isRightAssociative(char operator) {
        return operator == '^';  // Exponentiation is right-associative
    }

    // Get precedence of an operator
    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

}
