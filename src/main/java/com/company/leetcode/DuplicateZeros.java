package com.company.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/duplicate-zeros/description/
 * //https://www.youtube.com/watch?v=gaB-guUxCWI&t=14s
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 0, 2, 3, 0, 4, 5, 0})));
    }

    private static int[] solution(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(nums[i]);
            }
            Integer first = queue.poll();
            nums[i] = first;
        }
        return nums;
    }
}
