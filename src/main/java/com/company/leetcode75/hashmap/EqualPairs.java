package com.company.leetcode75.hashmap;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class EqualPairs {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(solution(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }

    private static int solution(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean isIdentical = true;
                for (int i = 0; i < n; i++) {
                    if (grid[r][i] != grid[i][c]) {
                        isIdentical = false;
                        break;
                    }
                }
                if (isIdentical) {
                    count++;
                }
            }
        }
        return count;
    }
}
