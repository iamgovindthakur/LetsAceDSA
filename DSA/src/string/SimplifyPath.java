package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class SimplifyPath {
    public static String simplifyPath(String path) {
        final String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        Deque<String> stack1 = new ArrayDeque<>();
        for (final String dir : dirs) {
            if (dir.isEmpty() || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
                stack1.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}