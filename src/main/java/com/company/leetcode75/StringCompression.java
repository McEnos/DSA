package com.company.leetcode75;
//https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
//https://medium.com/@sakalli.duran/efficient-string-compression-in-java-a-guide-to-leetcode-problem-443-698f6eaba36d
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(solution(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(solution(new char[]{'a'}));
    }

    private static int solution(char[] a) {
        int index = 0, i = 0;
        while (i < a.length) {
            char currentCharacter = a[i];
            int count = 0;
            while (i < a.length && a[i] == currentCharacter) {
                i++;
                count++;
            }
            a[index++] = currentCharacter;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    a[index++] = c;
                }
            }
        }
        return index;
    }
}
