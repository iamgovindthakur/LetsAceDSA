package stack;

import java.util.ArrayDeque;
import java.util.Deque;

class LargestRectangleInHistogram {
  static public int largestRectangleArea(int[] heights) {
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= heights.length; ++i) {
      while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
        final int h = heights[stack.pop()];
        final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, h * w);
      }
      stack.push(i);
    }

    return ans;
  }

  public static void main(String[] args) {

    int [] heights = {2,1,5,6,2,3};
    System.out.println(largestRectangleArea(heights));
  }
}
