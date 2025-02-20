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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val){
        if(root.val <= val && root.right != null){
            insert(root.right, val);
            return;
        }
        if(root.val > val && root.left != null){
            insert(root.left, val);
            return;
        }
        if(root.val <= val && root.right == null){
            root.right = new TreeNode(val);
        }
        if(root.val > val && root.left == null){
            root.left = new TreeNode(val);
        }
    }
}
