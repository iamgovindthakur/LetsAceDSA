package stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    static public int sumSubarrayMins2(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        long M = (long)1e9 + 7;
        stack.push(-1);

        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2<arr.length)? arr[i2] : 0;

            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (left * right * (long)arr[index]) % M;
                res += add ;
                res %= M;
            }

            stack.push(i2);

        }

        return (int)res;

    }

    static public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        long MOD = (long) 1e9 + 7;

        // Calculate the next smaller element on the left for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate the next smaller element on the right for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of minimum subarray elements
        for (int i = 0; i < n; i++) {
            long leftDist = i - left[i];
            long rightDist = right[i] - i;
            result += (arr[i] * leftDist * rightDist) % MOD;
            result %= MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int [] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMins2(arr));
    }
}
