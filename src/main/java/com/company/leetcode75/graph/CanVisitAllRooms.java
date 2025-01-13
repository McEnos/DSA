package com.company.leetcode75.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
 * https://algo.monster/liteproblems/841
 * https://chatgpt.com/c/66ea30c1-2ed4-8011-bdc6-314cb72043b5
 * https://leetcode.com/problems/keys-and-rooms/solutions/5543357/depth-first-search-solution-beats-100
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {

        System.out.println(solution(List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        )));
    }

    private static boolean solutionV2(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int neighbour : rooms.get(currentRoom)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private static boolean solution(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        visited[currentRoom] = true;
        for (int neighbour : rooms.get(currentRoom)) {
            if (!visited[neighbour]) {
                dfs(rooms, neighbour, visited);
            }
        }
    }
}
