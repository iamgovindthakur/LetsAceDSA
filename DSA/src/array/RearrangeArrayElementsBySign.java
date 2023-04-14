package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative integers into separate ArrayLists
        for (int x : nums) {
            if (x > 0) {
                pos.add(x);
            } else {
                neg.add(x);
            }
        }

        // Merge the two ArrayLists alternately
        int i = 0;
        int j = 0;
        while (i < pos.size() && j < neg.size()) {
            nums[i + j] = pos.get(i);
            i++;
            nums[i + j] = neg.get(j);
            j++;
        }

        // Add any remaining integers from the positive or negative ArrayList
        while (i < pos.size()) {
            nums[i + j] = pos.get(i);
            i++;
        }
        while (j < neg.size()) {
            nums[i + j] = neg.get(j);
            j++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

}
