/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int val = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        int curr = findHeight(root.left) + findHeight(root.right);
        return Math.max(val, curr);
    }
}
