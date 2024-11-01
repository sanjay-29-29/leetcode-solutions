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
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root.left == null && root.right == null){
            list.add(String.valueOf(root.val));
            return list;
        }
        backTrack(root.left, String.valueOf(root.val));
        backTrack(root.right, String.valueOf(root.val));
        return list;
    }

    private void backTrack(TreeNode root, String s){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            s = s + "->" + root.val;
            s = s.substring(0,s.length());
            list.add(s);
        }

        backTrack(root.right, s + "->" + root.val);
        backTrack(root.left, s + "->" + root.val);
    }
}
