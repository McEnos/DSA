package com.company.codingproblems.two;

public class NullReferenceCheck {
    public static void main(String[] args) {

    }

    private static boolean solution(String value) {
        return value != null;
    }

    private static boolean solutionV1(String value) {
        if (value == null)
            throw new NullPointerException("Object cannot be null");
        return false;
    }

}
