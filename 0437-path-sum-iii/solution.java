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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        caller(root, targetSum);
        return count;
    }
    private void caller(TreeNode root, long targetSum){
        if(root == null){
            return;
        }
        bfs(root, targetSum);
        caller(root.left,targetSum);
        caller(root.right, targetSum);
    }
    private void bfs(TreeNode root, long targetSum){
        if(root!= null && targetSum-root.val == 0){
            count++;
        }
        if(root == null){
            return;
        }
        bfs(root.left, targetSum - root.val);
        bfs(root.right, targetSum - root.val);
    }
}
