package array;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

class LeadersInAnArray {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int[] arr, int n) {
        // Your code here
        if (n == 1)

            return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > stack.peek()) {
                stack.push(arr[i]);
            }
        }

        return new ArrayList<>(stack);

        //return new ArrayList<>();
    }

    public static void main(String[] args) {
        int n = 6;
        int A[] = {16, 17, 4, 3, 5, 2};

        System.out.println(leaders(A, n));
    }
}