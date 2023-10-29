package graph;

import java.util.*;

class DijkstraAlgorithm {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.distance).thenComparingInt(p -> p.node));

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE / 2);
        distance[S] = 0;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            for (ArrayList<Integer> u : adj.get(node.node)) {
                if (node.distance + u.get(1) < distance[u.get(0)]) {
                    distance[u.get(0)] = node.distance + u.get(1);
                    pq.add(new Pair(u.get(0), distance[u.get(0)]));
                }
            }
        }
        for (int i = 0; i < V; i++)
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