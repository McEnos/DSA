package com.company.codingproblems.one;

import java.util.Collections;

public class ConcatenateString {
    public static void main(String[] args) {
        System.out.println(solution("joshua",5));
    }

    private static String solution(String value, int n) {
        return value.repeat(n);
    }
    private static  String solutionV2(String value, int n){
        return String.join("", Collections.nCopies(n,value));
    }
}
