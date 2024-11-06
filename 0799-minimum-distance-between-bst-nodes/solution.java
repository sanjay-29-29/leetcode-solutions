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
    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        inorder(root);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - 1; i++) {
            diff = Math.min(list.get(i + 1) - list.get(i), diff);
        }
        return diff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
