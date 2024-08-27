package com.company.codingproblems.one;

public class ConvertStringToNumber {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        final String TO_INT = "453";
        final String TO_LONG = "45234223233";
        final String TO_FLOAT = "45.823F";
        final String TO_DOUBLE = "13.83423D";

        try {
            int integer = Integer.parseInt(TO_INT);
            System.out.println(integer);
            double doubleValue = Double.parseDouble(TO_DOUBLE);
            System.out.println(doubleValue);
            long longValue = Long.parseLong(TO_LONG);
            System.out.println(longValue);
            float floatValue = Float.parseFloat(TO_FLOAT);
            System.out.println(floatValue);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void solutionV2() {
        final String TO_INT = "453";
        final String TO_LONG = "45234223233";
        final String TO_FLOAT = "45.823F";
        final String TO_DOUBLE = "13.83423D";

        try {
            Integer integer = Integer.valueOf(TO_INT);
            Long longValue = Long.valueOf(TO_LONG);
            Float floatValue = Float.valueOf(TO_FLOAT);
            Double doubleValue = Double.valueOf(TO_DOUBLE);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
