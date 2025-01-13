package com.company.hackerrank;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 */
public class IsBalanced {
    public static void main(String[] args) {
        System.out.println(solution("{{[[(())]]}}"));
        System.out.println(solution("{[()]}"));
    }

    private static String solution(String s) {
        if (s.length() % 2 != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (opening(c)) {
                stack.push(c);
            } else if(closing(c)) {
                if (stack.isEmpty()) {
                    return "NO";
                }
                Character top = stack.peek();
                if (matching(top, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";

    }

    private static boolean opening(char c) {
        return Arrays.asList('[', '{', '(').contains(c);
    }

    private static boolean closing(char c) {
        return Arrays.asList(')', ']', '}').contains(c);
    }

    private static boolean matching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
}
