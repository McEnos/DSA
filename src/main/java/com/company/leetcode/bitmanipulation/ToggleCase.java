package com.company.leetcode.bitmanipulation;

public class ToggleCase {
    public static void main(String[] args) {
        System.out.println(solution("Hello World"));
    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                sb.append(c);
            } else {
                sb.append(c ^= 32);
            }

        }
        return sb.toString();
    }
}
