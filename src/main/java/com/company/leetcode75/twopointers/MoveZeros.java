package com.company.leetcode75.twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
//https://leetcode.com/problems/move-zeroes/solutions/5546261/other-approach-than-two-pointers-beginner-approach-beats-100/
public class MoveZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{0, 0})));
        //  System.out.println(Arrays.toString(solution(new int[]{1, 1, 0, 3, 12})));
    }

    private static int[] solution(int[] a) {
        int position = 0;
        for (int num : a) {
            if (num != 0) {
                a[position++] = num;
            }
        }
        while (position < a.length) {
            a[position++] = 0;
        }
        return a;
    }

    /**
     * Uses 2 pointers
     */

    private static int[] solutionV2(int[] a) {
        int i = 0;
        int j = 0;
        while (j < a.length) {
            if (a[j] == 0) {
                j++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
