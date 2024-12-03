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
    int retCount;

    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return retCount;     
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }

        if((calcAverage(root) / count) == root.val){
            retCount++;
        }

        count = 0;

        traverse(root.left);
        traverse(root.right);
    }

    private int calcAverage(TreeNode root){
        if(root == null){
            return 0;
        }
        count++;
        return root.val + calcAverage(root.left) + calcAverage(root.right);
    }
}
