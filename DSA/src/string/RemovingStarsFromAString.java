package string;

import java.util.ArrayDeque;

public class RemovingStarsFromAString {

    public static String removeStars(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                queue.pollLast();
            } else queue.add(c);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) res.append(queue.poll());
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public String removeStars2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
