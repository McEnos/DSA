package com.company.leetcode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(solution("a##", ""));
    }

    private static boolean solution(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private static String helper(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == '#') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }

            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
