package array.slidingWindow;

class CountNumberOfNiceSubarrays {
    static public int numberOfSubarrays(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0) k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}