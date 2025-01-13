package com.company.leetcode.arrays;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * 485 Max Consecutive ones
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,0,1,1,1}));
        System.out.println(solution(new int[]{1,0,1,1,0,1}));
    }

    private static int solution(int[] nums) {
        int currentCount = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                //checking if the current streak (currentCount) is greater than maxCount whenever a 0 is encountered,
                // which is the correct approach to ensure that you don't lose track of the longest streak.
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        //At the end of the loop,also handle the case where the array ends with a streak of
        // 1s (since you might not encounter another 0 after that streak).
        return Math.max(maxCount, currentCount);
    }
}
