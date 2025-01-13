package com.company.leetcode.leetcode75;

/**
 * https://algo.monster/liteproblems/238
 * https://leetcode.com/problems/product-of-array-except-self/submissions/1460462361/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] nums) {
        int length = nums.length;
        int[] prefixProduct = new int[length];
        int[] suffixProduct = new int[length];
        int[] result = new int[length];
        prefixProduct[0] = 1;
        suffixProduct[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = prefixProduct[i] + suffixProduct[i];
        }

        return result;
    }

}
