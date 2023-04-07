package binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    static int firstOccurrence(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            final int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid;
            else l = mid + 1;

        }
        return l;
    }

    static public int[] searchRange(int[] nums, int target) {
        int firstIndex = firstOccurrence(nums, target);
        if (nums[firstIndex] != target)
            return new int[]{-1, -1};
        int lastIndex = firstOccurrence(nums, target + 1) - 1;
        return new int[]{firstIndex, lastIndex};

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
