package com.company.leetcode.greedy;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 * 678. Valid Parenthesis String
 */
public class CheckValidString {
    public static void main(String[] args) {
        System.out.println(solution("()"));
        System.out.println(solution("(*)"));
        System.out.println(solution("(*))"));
    }

    private static boolean solution(String s) {
        int minOpen = 0; //Minimum possible open parentheses
        int maxOpen = 0; // Maximum possible open parentheses.
        for (char c : s.toCharArray()) {
            // Treat '(' as an open parenthesis
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                // '*' can be treated as '(', ')' or ""
                minOpen--; //Treat '*' as ')'
                maxOpen++; //treat '*' as '('
            }
            // If at any  point, maxOpen becomes negative, it means there are too many ')'
            if (maxOpen < 0) {
                return false;
            }
            // minOpen should never be negative, as we cannot have unmatched ')' without '('
            minOpen = Math.max(minOpen, 0);
        }
        // if minOpen is 0, it means all '(' can be matched with ')'
        return minOpen == 0;
    }
}
