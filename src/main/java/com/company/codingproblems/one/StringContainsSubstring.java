package com.company.codingproblems.one;

public class StringContainsSubstring {
    public static void main(String[] args) {

    }

    private static boolean solution(String value, String substring) {
        return value.contains(substring);
    }
    private static boolean solutionV2(String value, String substring){
        return value.indexOf(substring) != -1;
    }
}
