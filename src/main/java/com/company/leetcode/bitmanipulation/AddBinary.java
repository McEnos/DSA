package com.company.leetcode.bitmanipulation;

//https://leetcode.com/problems/add-binary/?envType=problem-list-v2&envId=bit-manipulation
public class AddBinary {
    public static void main(String[] args) {

    }

    private static String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = bitA + bitB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
