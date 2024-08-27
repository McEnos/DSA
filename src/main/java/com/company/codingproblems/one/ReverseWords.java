package com.company.codingproblems.one;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(solution("Joshua Hi"));
    }
    private static String solution(String value){
        StringBuilder sb = new StringBuilder();
        String[] words = value.split(" ");
        for(int i=words.length - 1; i >= 0;i--){
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
