package com.company.leetcode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 5, 1, 3}, 3));
        System.out.println(solution(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(solution(new int[]{12, 1, 12}, 10));
    }

    public static List<Boolean> solution(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maximumCandiesInArray = candies[0];
        for (int candy : candies) {
            if (candy > maximumCandiesInArray) {
                maximumCandiesInArray = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= maximumCandiesInArray) {
                result.add(true);
            }
            result.add(false);
        }
        return result;
    }

}
