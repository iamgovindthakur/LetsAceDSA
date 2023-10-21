package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // add your code here
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (List<Integer> u : prerequisites)
            adj[u.get(1)].add(u.get(0));

        int[] indegree = new int[n];

        int[] topoSort = new int[n];

        for (List<Integer> v : adj) {
            for (int i : v)
                indegree[i]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) queue.add(i);
        //System.out.println(queue);
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[index++] = node;

            for (int u : adj[node]) {
                indegree[u]--;
                if (indegree[u] == 0) queue.add(u);
            }
        }

        return index == n ? topoSort : new int[]{};
    }

    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int[] u : prerequisites)
            adj.get(u[0]).add(u[1]);

        int[] indegree = new int[N];

        int[] topoSort = new int[N];

        for (List<Integer> v : adj) {
            for (int i : v)
                indegree[i]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++)
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

        return index == N;
    }
}