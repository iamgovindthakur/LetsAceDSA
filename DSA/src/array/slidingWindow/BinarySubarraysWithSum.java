package array.slidingWindow;

class BinarySubarraysWithSum {

    // public int numSubarraysWithSum(int[] A, int S) {
    //     int psum = 0, res = 0, count[] = new int[A.length + 1];
    //     count[0] = 1;
    //     for (int i : A) {
    //         psum += i;
    //         if (psum >= S)
    //             res += count[psum - S];
    //         count[psum]++;
    //     }
    //     return res;
    // }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0) S += A[i++];
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));


    }
}