package stack;

import java.util.Stack;

class MaximalRectangle {
    static public int maximalRectangle(char[][] matrix) {


        int maxArea = largestHistogramArea(matrix[0]);
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = matrix[row][col] == '1' ? (char) (matrix[row - 1][col] + 1) : '0';
            }
            maxArea = Math.max(maxArea, largestHistogramArea(matrix[row]));
        }
        return maxArea;
    }

    static int largestHistogramArea(char[] matrix) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= matrix.length; i++) {
            while (!stack.isEmpty() && (i == matrix.length || matrix[stack.peek()] > matrix[i])) {
                int height = matrix[stack.pop()] - '0';
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        System.out.println(maximalRectangle(matrix));
    }
}