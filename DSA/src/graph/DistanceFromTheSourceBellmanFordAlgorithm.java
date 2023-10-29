package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DistanceFromTheSourceBellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);

        dist[S] = 0;

        for (int i = 0; i < V; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
            }
        }

        //to check if it has negative cycle

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                dist = new int[1];
                dist[0] = -1;
                return dist;
            }
        }
        return dist;
    }
}

