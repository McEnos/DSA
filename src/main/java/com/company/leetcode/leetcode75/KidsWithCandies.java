package com.company.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 */
public class KidsWithCandies {
    public static void main(String[] args) {

    }

    private static List<Boolean> solution(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int largestCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > largestCandies) {
                largestCandies = candy;
            }
        }
        for (int candy : candies) {
            int totalCandies = candy  + extraCandies;
            result.add(totalCandies >= largestCandies);
        }
        return result;
    }
}
