package stack;

import java.util.*;

class NextGreaterElementI {
  static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> numToNextGreater = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack

    for (final int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num)
        numToNextGreater.put(stack.pop(), num);
      stack.push(num);
    }

    for (final int num : nums1)
      ans.add(numToNextGreater.getOrDefault(num, -1));

    return ans.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int [] nums1 = {4,1,2};
    int [] nums2 = {1,3,4,2};
    System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
  }
}