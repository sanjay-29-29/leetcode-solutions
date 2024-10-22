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
    List<List<Integer>> l;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        l = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        recursion(root, targetSum, list);
        return l;
    }
    
    private void recursion(TreeNode root, int targetSum, List<Integer> list){
        List<Integer> newL = new ArrayList<Integer>();
        if(root!= null && targetSum-root.val == 0 && root.left == null && root.right == null){
            newL.addAll(list);
            newL.add(root.val);
            l.add(newL);
            return;
        }
        if(root == null){
            return;
        }
        newL.addAll(list);
        newL.add(root.val);
        recursion(root.left, targetSum-root.val, newL);
        recursion(root.right, targetSum-root.val, newL);
    }
}
