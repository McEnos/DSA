package com.company.leetcode.hundredquestions.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 152 Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/solutions/1608862/java-3-solutions-detailed-explanation-using-image
 */
public class MaxProduct {
    public static void main(String[] args) {

    }

    /**
     * Kadane algorithm concept but with a twist
     */
    private static int solution(int[] nums) {
        if (nums.length == 0) return 0;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
