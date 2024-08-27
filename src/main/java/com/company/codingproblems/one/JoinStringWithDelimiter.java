package com.company.codingproblems.one;

import java.util.List;
import java.util.StringJoiner;

public class JoinStringWithDelimiter {
    public static void main(String[] args) {
        System.out.println(solution(List.of("Joshua", "Enos", "Odiwuor"), ","));
    }

    private static String solution(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    private static String solutionV2(String delimiter, String... values) {
        StringBuilder sb = new StringBuilder();
        int count;
        for (count = 0; count < values.length - 1; count++) {
            sb.append(values[count]).append(delimiter);
        }
        sb.append(values[count]);
        return sb.toString();
    }

    private static String solutionV3(String delimiter, String... values) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (String value : values) {
            joiner.add(value);
        }
        return joiner.toString();
    }
}
