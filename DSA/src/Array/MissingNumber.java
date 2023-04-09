package Array;

class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return actualSum - sum;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}