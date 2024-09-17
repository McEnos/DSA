package com.company.bitmanipulation;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(solution(32));
    }

    private static String solution(int a) {
        String binaryString = Integer.toBinaryString(a);
        StringBuilder binary = new StringBuilder();

        while (a > 0) {
            binary.append(a%2);
            a = a / 2;

        }



        return binary.reverse().toString();
    }

    private static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;


    }
}
