package com.company.leetcode75.graph;

import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75
 * https://chatgpt.com/c/66ea30c1-2ed4-8011-bdc6-314cb72043b5
 */
public class FindCircleNum {
    int[] parent;
    int[] rank;

    public static void main(String[] args) {

    }

    /**
     * DFS
     */
    private static int solution(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        //Iterate through each city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //Found a new  province
                count++;
                //start DFS from city i
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    // Visit all directly connected cities
                    for (int j = 0; j < n; j++) {
                        if (isConnected[current][j] == 1 && !visited[j]) {
                            stack.push(j);
                            visited[j] = true;
                        }
                    }
                }
                // After DFS, increment the province count

            }

        }
        return count;
    }

    private int solution2(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        // Initialize the parent array where each city is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        // For each pair of cities, if they are connected, perform a union operation
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == find(i)) {
                count++;
            }
        }
        return count;

    }

    // Union function to merge two cities
    private void union(int city1, int city2) {
        int root1 = find(city1);  // Find the root of city1
        int root2 = find(city2);  // Find the root of city2

        if (root1 != root2) {  // If the roots are different, we need to unite them
            if (rank[root1] > rank[root2]) {  // Root1 has higher rank, so root2 becomes a child of root1
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {  // Root2 has higher rank, so root1 becomes a child of root2
                parent[root1] = root2;
            } else {  // Ranks are equal, so we arbitrarily make root1 the parent of root2 and increment root1's rank
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    // Find function with path compression
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression: make the parent of 'node' point directly to the root
        }
        return parent[node];
    }
}
