package com.company.codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 3)));
    }

    private static int[] solution(int[] A, int k) {
        int[] result = new int[A.length];
        int length = A.length;
        if (length == 0)
            return A;
        k = k % length;
        if (k == 0)
            return A;

        return result;
    }
}
