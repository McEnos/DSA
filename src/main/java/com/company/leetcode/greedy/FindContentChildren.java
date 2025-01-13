package com.company.leetcode.greedy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/
 * Time complexity O(nlogn)
 * Space complexity O(1)
 * https://leetcode.com/problems/assign-cookies/solutions/4485313/java-solution-for-assign-cookies-problem
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(solution(new int[]{1,2}, new int[]{1,2,3}));
    }

    private static int solution(int[] greed, int[] cookieSize) {
        Arrays.sort(cookieSize);
        Arrays.sort(greed);

        int childIndex = 0;
        int cookieIndex = 0;
       //Try to satisfy as many children as possible
        while (childIndex < greed.length && cookieIndex < cookieSize.length) {
            //If the current cookie can satisfy the current child, mode to the next child
            if (cookieSize[cookieIndex] >= greed[childIndex]) {
                childIndex++;
            }
            //Whether the cookie satisfies the child or not, move to the next child
            cookieIndex++;
        }
        //The number of satisfied children is childIndex
        return childIndex;
    }
}
