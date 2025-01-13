package com.company.leetcode.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/duplicate-zeros/description/
 * 1089. Duplicate Zeros
 */
public class DuplicateZeros {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.add(i);
                queue.add(0);
            } else {
                queue.add(i);
            }
            Integer first = queue.poll();
            nums[i] = first;
        }
        return nums;
    }


}
