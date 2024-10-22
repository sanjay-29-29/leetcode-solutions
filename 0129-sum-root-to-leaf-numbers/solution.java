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
    List<String> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<String>();
        recursion(root, "");
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }
    private void recursion(TreeNode root, String current){
        String newString;
        if(root!=null && root.left == null && root.right == null){
            newString = current + root.val;
            list.add(newString);
            return;
        }
        if(root == null){
            return;
        }
        newString = current + root.val;
        recursion(root.left, newString);
        recursion(root.right, newString);
    }

}
