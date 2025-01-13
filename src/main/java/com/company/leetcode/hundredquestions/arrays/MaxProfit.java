package com.company.leetcode.hundredquestions.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 121. Best Time to Buy and Sell Stock
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * The key is to iterate through the prices, keep track of the minimum price seen so far (the best day to buy),
     * and calculate the maximum profit at each step (the best day to sell after buying at the minimum price).
     */
    private static int solution(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
