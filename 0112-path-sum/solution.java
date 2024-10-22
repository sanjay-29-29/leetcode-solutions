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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return recursion(root, targetSum);
    }
    private boolean recursion(TreeNode root, int targetSum){
        if(root != null && targetSum-root.val==0 && root.left == null && root.right == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return recursion(root.left, targetSum-root.val) || recursion(root.right, targetSum-root.val);
    }
}
