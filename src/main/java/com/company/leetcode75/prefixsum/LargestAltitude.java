package com.company.leetcode75.prefixsum;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 * To find the highest altitude, we need to calculate the cumulative sum of the altitude gains at each step.
 * Starting from the initial altitude of 0, we keep adding the gain at each step to the current altitude.
 * The highest altitude reached during this process is the answer we are looking for.
 */
public class LargestAltitude {
    public static void main(String[] args) {

    }

    private static int solution(int[] gain) {
        int maxGain = 0;
        int sum = 0;
        for (int num : gain) {
            sum += num;
            maxGain = Math.max(maxGain, sum);
        }
        return maxGain;
    }
}
