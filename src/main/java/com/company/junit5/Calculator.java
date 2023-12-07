package com.company.junit5;

public class Calculator implements Comparable<Calculator> {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int compareTo(Calculator o) {
        return 0;
    }
}
