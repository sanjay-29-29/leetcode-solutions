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
    List<Integer> list;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        recursion(root);
        return list;
    }

    public void recursion(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        recursion(root.left);
        recursion(root.right);
    }
}
