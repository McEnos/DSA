package com.company.graphs;

import java.util.*;

public class Graph {
    private List<List<Integer>> adj = new ArrayList<>();
    private int V;
    private int E;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0; //at start, no edge is created
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    bfs.add(node);
                    for (Integer neighbour : adj.get(node)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
        return bfs;
    }

    public List<Integer> dfs(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    dfs.add(node);
                    for (Integer neighbour : adj.get(node)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            stack.push(neighbour);
                        }
                    }
                }
            }
        }
        return dfs;
    }
    public boolean bfsCycleDetection(){
        //https://qr.ae/pvAP9D
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.printGraph();
        System.out.println(g.bfs(g.V, g.adj));
        System.out.println(g.dfs(g.V, g.adj));
    }
}
