package com.company.leetcode.greedy;

/**
 * https://leetcode.com/problems/gas-station/
 * 134. Gas Station
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}, new int[] {3,4,5,1,2}));
        System.out.println(solution(new int[]{2,3,4}, new int[] {3,4,3}));
    }

    private static int solution(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            //if tank is negative , reset the starting index and tank balance
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        // if total gas is less than total cost return -1
        if (totalGas < totalCost) {
            return -1;
        }
        return startIndex;
    }
}
