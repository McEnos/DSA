package com.company.hackerrank;

import java.util.List;

public class JumpingOnClouds {
    public static void main(String[] args) {

    }

    private static int solution(List<Integer> c) {
        int n = c.size();
        int jumps = 0;
        int index = 0;
        while (index < n - 1) {
            if (index + 2 < n && c.get(index + 2) == 0) {
                index += 2;
            } else {
                index++;
            }
            jumps++;
        }
        return jumps;
    }
}
