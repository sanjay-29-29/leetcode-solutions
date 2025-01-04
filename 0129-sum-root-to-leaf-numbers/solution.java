/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // int val;
    // Set<TreeNode> set = new HashSet<>();

    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
        // return val;
    }

    private int traverse(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            // System.out.println(sum);
            sum = (sum * 10) + root.val;
            return sum;
        }

        // System.out.println(root.val);
        sum = (sum * 10) + root.val;

        return traverse(root.left, sum) +
                traverse(root.right, sum);
    }
}
