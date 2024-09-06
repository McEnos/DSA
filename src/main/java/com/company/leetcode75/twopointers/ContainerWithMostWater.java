package com.company.leetcode75.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/solutions/1915172/java-c-easiest-explanations/?envType=study-plan-v2&envId=leetcode-75
 * https://www.youtube.com/watch?v=KhL8cnEk65A
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentWidth * currentHeight;
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
