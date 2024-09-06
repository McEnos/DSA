package com.company.leetcode75;

import java.util.Arrays;
//https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview
//https://medium.com/@acomputerscientistsdiary/a-leetcode-a-day-product-of-array-except-self-problem-0eef97686b44
public class ProductExceptSelf {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(prefixSummation(new int[]{1, 2, 3, 4, 5})));
        // System.out.println(Arrays.toString(prefixProduct(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{-1, 1, 0, -3, 3})));
    }

    /**
     * Bruteforce method
     */

    public static int[] solution(int[] a) {
        int length = a.length;
        int[] result = new int[a.length];
        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = 0; j < length; j++) {
                if (i == j)
                    continue;
                product = product * a[j];
            }
            result[i] = product;
        }

        return result;
    }

    /**
     * Does not work when an element is zero, since division by zero is not possible
     *
     * @param a
     * @return
     */
    private static int[] solutionV2(int[] a) {
        int product = 1;
        int length = a.length;
        for (int i : a) {
            product *= i;
        }
        int[] ans = new int[a.length];
        for (int i = 0; i < length; i++) {
            ans[i] = product / a[i];
        }
        return ans;
    }

    /**
     * Using prefix product and suffix product
     *  Optimized
     * @param a
     */
    private static int[] solutionV3(int[] a) {
        int[] prefixProduct = new int[a.length];
        int[] suffixProduct = new int[a.length];
        prefixProduct[0] = 1;
        suffixProduct[a.length - 1] = 1;
        int[] result = new int[a.length];

        //Fill in prefix product array
        for (int i = 1; i < a.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * a[i - 1];
        }
        //Fill in suffix product
        for (int i = a.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * a[i + 1];
        }
        //fill in the resulting array
        for (int i = 0; i < a.length; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }
        return result;
    }

    private static int[] prefixSummation(int[] a) {
        int[] result = new int[a.length];
        result[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            result[i] = a[i] + result[i - 1];
        }
        return result;
    }

    private static int[] suffixSummation(int[] a) {
        int[] result = new int[a.length];
        result[0] = a[0];
        for (int i = a.length - 1; i >= 1; i--) {
            result[i] = a[i] + result[i - 1];
        }
        return result;
    }

    private static int[] suffixArray(int[] a, int index) {
        int[] result = new int[a.length - index];
        for (int i = index; i < a.length; i++) {
            result[i - index] = a[i];
        }
        return result;
    }

    private static int[] prefixProduct(int[] a) {
        int[] result = new int[a.length];
        result[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i];
        }
        return result;
    }
}
