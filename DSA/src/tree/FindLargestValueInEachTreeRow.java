package tree;


import java.util.*;


class FindLargestValueInEachTreeRow {

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> rowMaxVals = new ArrayList<>();
        if (root == null) return rowMaxVals;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelMax = Integer.MIN_VALUE;
            for (TreeNode node : new ArrayList<>(queue)) {
                queue.remove();
                levelMax = Math.max(levelMax, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            rowMaxVals.add(levelMax);
        }
        return rowMaxVals;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(9);
        System.out.println(largestValues(tree));
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}