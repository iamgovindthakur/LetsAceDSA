package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AlienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cada"};
        System.out.println(findOrder(dict, N, K));
    }

    public static String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<Integer>[] adj = new List[K];

        for (int i = 0; i < K; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int len = Math.min(dict[i].length(), dict[i - 1].length());
            for (int j = 0; j < len; j++) {
                if (dict[i].charAt(j) != dict[i - 1].charAt(j)) {
                    adj[dict[i - 1].charAt(j) - 'a'].add(dict[i].charAt(j) - 'a');
                    break;
                }
            }
        }
        int[] inOrder = new int[K];

        for (int i = 0; i < K; i++) {
            for (int val : adj[i])
                inOrder[val]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inOrder.length; i++)
            if (inOrder[i] == 0) queue.add(i);

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.append((char) ('a' + node));
            for (int u : adj[node]) {
                inOrder[u]--;
                if (inOrder[u] == 0) queue.add(u);
            }
        }
        return res.toString();
    }
}