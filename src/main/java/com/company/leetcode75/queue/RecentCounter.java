package com.company.leetcode75.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 * https://leetcode.com/problems/number-of-recent-calls/solutions/594800/question-and-solution-both-clearly-explained
 */
public class RecentCounter {
    Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
