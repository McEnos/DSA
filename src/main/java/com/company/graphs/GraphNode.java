package com.company.graphs;

import java.util.*;

//Node to store vertex and its parent into in BFS
public class GraphNode {
    int v, parent;

    GraphNode(int v, int parent) {
        this.v = v;
        this.parent = parent;
    }
}

// A class to store a graph edge
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class GraphV2 {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    //Constructor
    GraphV2(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        //add edges to the undirected graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // List of graph edges
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 4), new Edge(1, 5), new Edge(4, 8),
                new Edge(4, 9), new Edge(3, 6), new Edge(3, 7),
                new Edge(6, 10), new Edge(6, 11), new Edge(5, 9)
                // edge (5, 9) introduces a cycle in the graph
        );
        int n = 12;
        //build a graph from the given edges
        GraphV2 graph = new GraphV2(edges,n);

        //perform BFS
        if (BFS(graph,0,n)){
            System.out.println("Graph contains a cycle");
        }else{
            System.out.println("No cycle detected");
        }


    }
   //Perform BFS on the graph starting from vertex src and
    //return true if a cycle is found in the graph
    public static boolean BFS(GraphV2 graph, int src, int n) {
        //to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
        //mark the source vertex as discovered
        discovered[src] = true;
        //create a queue for doing BFS and enqueue source vertex
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(new GraphNode(src, -1));
        //Loop  till queue is empty
        while (!queue.isEmpty()) {
            //dequeue front node
            GraphNode node = queue.poll();
            for (int u : graph.adjList.get(node.v)) {
                if (!discovered[u]) {
                    //mark it as discovered
                    discovered[u] = true;
                    //construct the queue node containing info
                    //about vertex and enqueue it
                    queue.add(new GraphNode(u, node.v));
                } else if (u != node.parent) {
                    //we found a cross edge, i.e the cycle is found
                    return true;
                }
            }
        }
        //no cross-edges were found in the graph
        return false;
    }

}