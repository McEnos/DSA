package com.company.codingproblems.one;

public class RemoveGivenCharacter {
    public static void main(String[] args) {
        System.out.println(solution("Joshuaaaaaa",'a'));
    }

    private static String solution(String value, char target) {
        StringBuilder sb = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (c != target) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
