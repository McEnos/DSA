package com.company.leetcode.leetcode75.twopointers;

/**
 * https://algo.monster/liteproblems/11
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxArea {
    public static void main(String[] args) {

    }

    private static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            // Calculate the area with the shorter line as the height and the distance between the lines as the width
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = currentHeight * width;
            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, currentArea);
            // Move the pointer that points to the shorter line towards the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
