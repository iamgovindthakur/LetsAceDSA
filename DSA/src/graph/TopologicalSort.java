package graph;

import java.util.*;

class TopologicalSort {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfsHelper(i, adj, stack, visited);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    private static void dfsHelper(int source, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[source] = true;
        for (int u : adj.get(source)) {
            if (!visited[u]) dfsHelper(u, adj, stack, visited);
        }
        stack.push(source);
    }

    static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        int[] topoSort = new int[V];

        for (List<Integer> v : adj) {
            for (int i : v)
                indegree[i]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++)
            if (indegree[i] == 0) queue.add(i);

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[index++] = node;

            for (int u : adj.get(node)) {
                indegree[u]--;
                if (indegree[u] == 0) queue.add(u);
            }
        }

        return topoSort;
    }
}