package com.company.codingproblems.one;

public class StringOnlyDigits {
    public static void main(String[] args) {
        System.out.println(solution("46475"));
    }
    private static boolean solution(String value){
        for(char c: value.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    private static  boolean solutionV2(String value){
        return value.chars()
                .anyMatch(v -> !Character.isDigit(v));
    }
}
