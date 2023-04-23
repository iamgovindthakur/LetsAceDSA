package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMissingAndRepeating {

    static int[] findTwoElement(int arr[], int n) {
        // code here
        int missing = 0, repeating = 0;

        for (int i = 0; i < n; i++) {

            int val = Math.abs(arr[i]);

            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            } else {
                repeating = val;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 5, 6};
        int n = arr.length;

        System.out.println(Arrays.toString(findTwoElement(arr, n)));
    }
}
