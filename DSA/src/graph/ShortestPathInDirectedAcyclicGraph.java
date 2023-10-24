package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ShortestPathInDirectedAcyclicGraph {

    static void topoSort(int source, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
        for (Pair pair : adj.get(source))
            if (!visited[pair.node]) topoSort(pair.node, adj, visited, stack);
        stack.push(source);
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        //creating adj list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        //populating the adj list with u,v and weight
        for (int[] edge : edges)
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));

        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) topoSort(i, adj, visited, stack);
        }

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE / 2);

        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Pair pair : adj.get(node)) {
                int v = pair.node;
                int weight = pair.weight;
                distance[v] = Math.min(distance[node] + weight, distance[v]);
            }
        }

        for (int i = 0; i < N; i++)
            if (distance[i] == Integer.MAX_VALUE / 2) distance[i] = -1;

        return distance;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};

        int N = 6;
        int M = 7;

        System.out.println(Arrays.toString(shortestPath(N, M, edges)));
    }

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}