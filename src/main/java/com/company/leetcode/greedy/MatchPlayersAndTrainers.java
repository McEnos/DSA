package com.company.leetcode.greedy;

import java.util.Arrays;

/**
 * 2410. Maximum Matching of Players With Trainers
 * https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
 * The idea is to sort them both in increasing order and try to train as much players as possible.
 * Time complexity O(nlogn) i.e O(max(nlogn, mlogm))
 * Space complexity O(n)
 */
public class MatchPlayersAndTrainers {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
        System.out.println(solution(new int[]{1,1,1}, new int[]{10}));
    }

    private static int solution(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int maxMatches = 0;
        int playerIndex = 0;
        int trainerIndex = 0;
        while (playerIndex < players.length && trainerIndex < trainers.length) {
            if (trainers[trainerIndex] >= players[playerIndex]) {
                maxMatches++;
                playerIndex++;
            }
            trainerIndex++;
        }
        return maxMatches;
    }
}
