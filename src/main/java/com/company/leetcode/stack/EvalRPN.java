package com.company.leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * 150. Evaluate Reverse Polish Notation
 */
public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2","1","+","3","*"}));
        System.out.println(solution(new String[]{"4","13","5","/","+"}));
    }

    private static int solution(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); // Pop the second operand
                int a = stack.pop(); // Pop the first operand
                int result = applyOperation(a, b, token);
                stack.push(result); // Push the result back to stack
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();  // Final result
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}
