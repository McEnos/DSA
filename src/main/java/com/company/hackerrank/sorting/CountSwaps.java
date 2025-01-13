package com.company.hackerrank.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSwaps {
    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(6,4,1)));
    }

    private static int solution(List<Integer> list) {
        int countSwaps = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    countSwaps++;
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        return countSwaps;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
