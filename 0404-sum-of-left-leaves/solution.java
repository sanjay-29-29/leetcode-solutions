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
    public int sumOfLeftLeaves(TreeNode root) {
        return calcSum(false, root);
    }

    private int calcSum(boolean isLeft, TreeNode root){
       if(root == null) {
            return 0;
       }
       if(root.left == null && root.right == null && isLeft){
            return root.val;
       }
       return calcSum(true, root.left) + calcSum(false, root.right);
    
    }
}
