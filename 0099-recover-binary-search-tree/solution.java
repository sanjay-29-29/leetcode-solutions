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
    List<Integer> oldList = new ArrayList<>();
    List<Integer> sortedList;
    int index = 0;

    public void recoverTree(TreeNode root) {
        traverse(root);
        sortedList = new ArrayList<>(oldList);
        Collections.sort(sortedList);
        replace(root);
    }

    private void replace(TreeNode root){
        if(root == null){
            return;
        }
        replace(root.left);
        if(sortedList.get(index) != oldList.get(index)){
            root.val = sortedList.get(index);
        }
        index++;
        replace(root.right);
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        oldList.add(root.val);
        traverse(root.right);
    }
}
