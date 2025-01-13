package com.company.leetcode.greedy;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/
 * 846. Hand of Straights
 */
public class IsNStraightHand {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,6,2,3,4,7,8},3));
        System.out.println(solution(new int[]{1,2,3,4,5},4));
    }

    private static boolean solution(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) { //Early exit if not divisible
            return false;
        }
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();

        //count each card
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        //Attempt to form groups
        while (!cardCounts.isEmpty()) {
            int first = cardCounts.firstKey(); //Start with the smallest card.
            for (int i = 0; i < groupSize; i++) {
                int currentCard = first + i;
                if (!cardCounts.containsKey(currentCard)) {
                    return false; //Can't form a group
                }
                //Decrease count or remove card if count is 0
                int count = cardCounts.get(currentCard);
                if (count == 1) {
                    cardCounts.remove(currentCard);
                } else {
                    cardCounts.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }
}
