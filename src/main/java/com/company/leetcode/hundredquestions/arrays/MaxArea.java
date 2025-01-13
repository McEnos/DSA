package com.company.leetcode.hundredquestions.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 11. Container With Most Water
 */
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = currentHeight * width;
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
