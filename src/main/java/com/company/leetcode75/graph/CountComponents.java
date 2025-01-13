package com.company.leetcode75.graph;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 * 323. Number of Connected Components in an Undirected Graph
 * https://chatgpt.com/c/66f7cfbe-1428-8011-a055-8f15c1738e76
 * https://algo.monster/liteproblems/323
 *
 * <p>
 * You are given a graph with n nodes, numbered from 0 to n-1, and an array edges where each edges[i] = [a, b]
 * represents an undirected edge between nodes a and b. Find the number of connected components in the graph.
 */
public class CountComponents {
    private int[] parent; // This array will hold the parent for each node representing the components
    private int[] rank;

    public static void main(String[] args) {
        // System.out.println(so);
        CountComponents cc = new CountComponents();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(cc.countComponents(n, edges));
    }

    private int countComponents(int n, int[][] edges) {
        // Initialize parent array, where initially each node is its own parent
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
        // For each edge, perform a union of the two vertices
        for (int[] edge : edges) {
            int vertex1 = edge[0], vertex2 = edge[1];
            union(vertex1, vertex2);
        }
        // Count the number of components by counting the nodes that are their own parents
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (i == find(i)) { // If the node's parent is itself, it's the root of a component
                count++;
            }
        }
        return count;
    }

    // Find function with path compression
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression for efficiency
        }
        return parent[node]; // Return the root parent of the node
    }

    // Union function to join two subsets into a single subset
    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

}
