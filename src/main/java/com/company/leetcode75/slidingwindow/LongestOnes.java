package com.company.leetcode75.slidingwindow;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * https://chatgpt.com/share/670f4254-d1bf-435d-87f1-0652537ae437
 */
public class LongestOnes {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        System.out.println(solution(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1, 1},2));
        System.out.println(solution(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }

    private static int solution(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1); //used to calculate current window size
        }
        return maxLength;
    }
}
