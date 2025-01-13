package com.company.codility;

import java.util.HashMap;
import java.util.Map;

public class PermMissingElem {
    public static void main(String[] args) {

    }

    private static int solution(int[] A) {
        int n = A.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : A) {
            map.put(num, true);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    private static int solutionV2(int[] A) {
        int N = A.length;
        long expectedSum = (long) (N + 1) * (N + 2) / 2;
        long actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }
        return (int) (expectedSum - actualSum);
    }
}
