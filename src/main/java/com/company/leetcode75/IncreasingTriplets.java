package com.company.leetcode75;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/solutions/3654102/simple-java-solution-from-a-beginner-for-a-beginner
 * The goal is to find a triplet of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * Probably need to store 2 values but no need to store the 3rd because we can just return true if the 3rd value is greatest
 * Utilize a two-pointer approach to keep track of the minimum and middle elements seen so far
 * Initialize two variables minNum and midNum to hold the minimum and middle elements, respectively.
 * Set both variables to the maximum possible value (Integer.MAX_VALUE) initially.
 * Iterate through the array nums from left to right.
 * For each number num encountered:
 * If num <= minNum, update minNum to num. This ensures that we always have the smallest number seen so far.
 * If minNum <= num <= midNum, update midNum to num. This ensures that we always have the second-smallest number seen so far.
 * If we encounter a number greater than both minNum and midNum, it means we have found an increasing triplet. Return true.
 * If we complete the iteration without finding an increasing triplet, return false.
 *
 * The solution works because if there exists an increasing triplet, the smallest and middle elements must be initialized at some point.
 * By updating minNum and midNum as we iterate through the array, we ensure that we always have the smallest and middle elements seen so far.
 * If a number greater than both minNum and midNum is encountered, it means we have found an increasing triplet, and we return true. Otherwise,
 * if we complete the iteration without finding a triplet, we return false.
 */
public class IncreasingTriplets {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
        System.out.println(solution(new int[]{2, 1, 5, 0, 4, 6}));
    }

    private static boolean solution(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int midNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= minNum) {
                minNum = num;
            } else if (num <= midNum) {
                midNum = num;
            } else {
                return true;
            }
        }
        return false;
    }

  /*  private static boolean solution(int[] nums) {
        int i = 0;
        int j = 1;
        for (int k = 2; k < nums.length; k++) {
            if (nums[k] > nums[j] && nums[j] > nums[i]) {
                return true;
            }
            i++;
            j++;
         //   System.gc();
        }
        return false;
    }*/
}
