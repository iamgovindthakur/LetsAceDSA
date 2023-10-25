package graph;

import java.util.*;

public class ShortestPathInUndirectedGraphHavingUnitDistance {

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE / 2);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair currNode = queue.poll();
            for (int u : adj.get(currNode.node)) {
                if (currNode.distance + 1 < distance[u]) {
                    distance[u] = currNode.distance + 1;
                    queue.add(new Pair(u, distance[u]));
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (distance[i] == Integer.MAX_VALUE / 2) distance[i] = -1;

        return distance;
    }

    static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}