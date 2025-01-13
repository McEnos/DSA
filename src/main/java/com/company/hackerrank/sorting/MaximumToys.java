package com.company.hackerrank.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */
public class MaximumToys {
    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(1,2,3,4),7));
    }

    private static int solution(List<Integer> prices, int k) {
        Collections.sort(prices);
        int count = 0;
        int price = 0;
        for (Integer integer : prices) {
            if (price + integer <= k) {
                price += integer;
                count++;
            }
        }

        return count;
    }
}
