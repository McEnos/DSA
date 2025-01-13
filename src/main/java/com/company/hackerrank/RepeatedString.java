package com.company.hackerrank;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(solution("aba", 10));
        System.out.println(solution("a", 100000000));
    }

    private static long solution(String s, long n) {
        int count = 0;
        // Step 1: Count 'a's in the original string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        // Step 2: Calculate how many full repetitions of 's' fit in 'n' characters
        long fullRepetitions = n / s.length();

        // Step 3: Calculate remaining characters after full repetitions
        long remainder = n % s.length();

        // Step 4: Count 'a's in the leftover part of the string
        long countOfAInRemainder = 0;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                countOfAInRemainder++;
            }
        }
        // Step 5: Calculate the total number of 'a's
        return (fullRepetitions * count) + countOfAInRemainder;
    }
}
