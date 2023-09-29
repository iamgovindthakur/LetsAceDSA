package array;

class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
}