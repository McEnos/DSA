package com.company.graphs;

import java.util.*;

public class GraphAdjList {
    private int vertices;
    private List<List<Integer>> adjList;


    private Map<Object, List<Object>> adjacencyList;

    public GraphAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private void bfs(int source) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ", ");

            for (int neighbour : adjList.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }

        }
    }

    private void dfsV2(int source) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        visited.add(source);
        stack.push(source);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + ", ");
            for (int neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
    }

    private void bfsV2(int source) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(source);
        queue.offer(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + ",  ");
            for (int neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }

    private void dfs(int source) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + ", ");
            for (int neighbour : adjList.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
    }

    private void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(5);

       /* graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);*/

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println("BFS version 1: ");
        graph.bfs(0);
        System.out.println("DFS version 2: ");
        graph.bfsV2(0);
        System.out.println();
        System.out.println();
        System.out.println("DFS version 1:");
        graph.dfs(0);
        System.out.println("DFS version 2:");
        graph.dfsV2(0);

    }
}
