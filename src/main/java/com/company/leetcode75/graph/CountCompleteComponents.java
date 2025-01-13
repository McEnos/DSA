package com.company.leetcode75.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-the-number-of-complete-components/
 * 2685. Count the Number of Complete Components
 * https://chatgpt.com/share/66fb6b92-5174-8011-bb19-40a2dd5d96bf
 *
 * https://leetcode.com/problems/count-the-number-of-complete-components/solutions/5077185/java-super-easy-clean-code-beats-87-14
 */
public class CountCompleteComponents {
    private List<List<Integer>> graph;
    boolean[] visited;

    public static void main(String[] args) {

    }

    private int solution(int n, int[][] edges) {
        graph = new ArrayList<>();
        visited = new boolean[n];
        // Initialize the graph as an adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Build the graph from the given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int completeComponents = 0;
        // Traverse through each node to find components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                int edgeCount = dfs(i, component);

                // Check if the component is complete
                if (isCompleteComponent(component, edgeCount)) {
                    completeComponents++;
                }

            }
        }
        return completeComponents;
    }

    private boolean isCompleteComponent(List<Integer> component, int edgeCount) {
        int size = component.size();
        int expectedEdges = size * (size - 1); // This counts each edge twice
        return edgeCount == expectedEdges;
    }

    private int dfs(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        int edgeCount = 0;
        for (int neighbor : graph.get(node)) {
            edgeCount++; // Each neighbor means an edge
            if (!visited[neighbor]) {
                edgeCount += dfs(neighbor, component);
            }
        }
        return edgeCount;
    }


}
