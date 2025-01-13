package com.company.leetcode75.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 * https://chatgpt.com/c/66e8f0dd-7604-8011-9bf1-9f579038e757
 */
public class PredictPartyVictory {
    public static void main(String[] args) {
        System.out.println(solution("RD"));
        System.out.println(solution("RDD"));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

    private static String solution(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
