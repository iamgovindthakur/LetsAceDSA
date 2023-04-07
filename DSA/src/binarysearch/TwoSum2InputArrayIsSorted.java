package binarysearch;

import java.util.Arrays;

//LC 167
public class TwoSum2InputArrayIsSorted {
    static public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }
        return new int[]{l + 1, r + 1};

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }
}
