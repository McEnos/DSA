package com.company.graphs;

import java.util.Scanner;

public class GraphAdjMatrix {
    private int[][] adjMatrix;
    private int vertices;

    public GraphAdjMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    private void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
        adjMatrix[destination][source] = 1;
    }

    private void removeEdge(int source, int destination) {
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    private void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = sc.nextInt();

        GraphAdjMatrix graph = new GraphAdjMatrix(vertices);

        System.out.println("Enter the number of edges:");
        int edges = sc.nextInt();

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Adjacency Matrix:");
        graph.printGraph();
    }

}
