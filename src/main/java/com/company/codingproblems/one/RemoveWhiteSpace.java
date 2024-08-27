package com.company.codingproblems.one;

public class RemoveWhiteSpace {
    public static void main(String[] args) {
        System.out.println(solution("Joshua is here"));
    }

    private static String solution(String value) {
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String solutionV2(String value){
        return value.replace("\\s","");
    }
}
