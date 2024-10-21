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
    public int goodNodes(TreeNode root) {
        return 1 + recursion(root.right, root.val) + recursion(root.left, root.val);
    }

    private int recursion(TreeNode root, int rootVal){
        if(root == null){
            return 0;
        }
        if(root.val >= rootVal){
            return 1 + recursion(root.right, root.val) + recursion(root.left, root.val);
        }else{
            return 0 + recursion(root.right, rootVal) + recursion(root.left, rootVal);
        }
    }
}
