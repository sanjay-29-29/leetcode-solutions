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

    public boolean findTarget(TreeNode root, int k) {
        traverse(root);
        Collections.sort(list);
        
        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            int leftVal = list.get(left);
            int rightVal = list.get(right);

            if(leftVal + rightVal == k){
                return true;
            }

            if(rightVal + leftVal < k){
                left++;
            }else{
                right--;
            }
        }

        return false;
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.val);
        
        traverse(root.left);
        traverse(root.right);
    }
}
