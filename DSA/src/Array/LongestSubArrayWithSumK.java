package Array;

import java.util.HashMap;
import java.util.Map;

class LongestSubArrayWithSumK {


    public static int lenOfLongSubarr(int[] A, int N, int K) {
        int mx = 0;
        int s = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < N; j++) {
            s += A[j];
            map.putIfAbsent(s, j);
            if (s == K) {
                mx = j + 1;
            } else if (map.containsKey(s - K)) {
                mx = Math.max(mx, j - map.get(s - K));
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        int A[] = new int[]{10, 5, 2, 7, 1, 9};
        int K = 15;
        System.out.println(lenOfLongSubarr(A, A.length, K));
    }
}