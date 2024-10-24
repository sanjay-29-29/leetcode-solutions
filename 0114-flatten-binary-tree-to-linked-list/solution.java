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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current == null){
                continue;
            }
            list.add(current);
            stack.add(current.right);
            stack.add(current.left);
        }
        for(int i=0;i<list.size()-1;i++){
            TreeNode current = list.get(i);
            current.right = list.get(i+1);
            current.left = null;
        }
    }
}
