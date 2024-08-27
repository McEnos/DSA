package com.company.codingproblems.one;

public class CharacterOccurrence {
    public static void main(String[] args) {
        System.out.println(solution("jjoahus", 'j'));
    }

    private static int solution(String value, char target) {
        int count = 0;
        for (char c : value.toCharArray()) {
            if (c == target) {
                count += 1;
            }
        }
        return count;
    }

    private static int solutionV2(String value, char target) {
        return value.chars()
                .filter(v -> v == target).reduce(0, Integer::sum);
    }

    private static int solutionV3(String value, char target) {
        return (int) value.chars()
                .filter(v -> v == target).count();
    }
}
