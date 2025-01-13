package com.company.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/description/?envType=problem-list-v2&envId=array
 * https://algo.monster/liteproblems/135
 *
 * https://www.youtube.com/watch?v=Ya-LfQ0OBkU
 * <p>
 * Time: O(n), where n is the number of children. We perform two passes over the ratings[] array.
 * Space: O(n), because we use an additional candies[] array to store the number of candies for each child.
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 2}));
        System.out.println(solution(new int[]{1, 2, 2}));
    }

    private static int solutionV2(int[] ratings) {
        int n = ratings.length;
        int candies = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //Left relative array
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        //Right relative array
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        //Merge the arrays
        for (int i = 0; i < n; i++) {
            candies += Math.max(left[i], right[i]);
        }
        return candies;
    }


    private static int solution(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Step 1: Give each child 1 candy initially
        Arrays.fill(candies, 1);
        // Step 2: Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Step 3: Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                /**
                 * Since we've already assigned candies in the left-to-right pass, we don't want to decrease the candies already given. So, we use:
                 */
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                /**
                 * The child at index i keeps their current candy count if it's already higher than what they would need to satisfy the right neighbor condition.
                 * If it's not, we increase the candy count to candies[i + 1] + 1 to ensure the condition is met.
                 */
            }
        }
        // Step 4: Sum up the candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
}
