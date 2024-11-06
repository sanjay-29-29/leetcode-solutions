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
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorderTraverse(root);
        for(int i = 0; i < list.size() - 1; i++){
            System.out.println(list.get(i));
            if(!(list.get(i) < list.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    private void inorderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        list.add(root.val);
        inorderTraverse(root.right);
    }
}
